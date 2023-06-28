package hexagonal.architecture.user.infrastructure.controllers;

import hexagonal.architecture.user.domain.UserSaveModel;
import hexagonal.architecture.user.domain.ports.UserServicePort;
import hexagonal.architecture.user.infrastructure.UserSavedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public final class SaveUserResource {
    private final UserServicePort service;
    private final ApplicationEventPublisher publisher;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Void> saveUser(@RequestBody @Valid UserSaveModel model) {
        var user = service.save(model);

        publisher.publishEvent(new UserSavedEvent(
                this,
                user.getEmail(),
                user.getUsername(),
                user.getId()));

        return ResponseEntity.created(URI.create("/api/users/")).build();
    }
}