package hexagonal.architecture.user.application.input;

import hexagonal.architecture.user.application.input.dto.UserSaveDTO;
import hexagonal.architecture.user.domain.service.UserServicePort;
import hexagonal.architecture.user.application.output.email.UserSavedEvent;
import hexagonal.architecture.user.infrastructure.UserCreatedStrategy;
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
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public final class SaveUserResource {
    private final UserServicePort service;
    private final ApplicationEventPublisher publisher;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Void> saveUser(@RequestBody @Valid UserSaveDTO model) {
        var user = service.save(model);

        publisher.publishEvent(new UserSavedEvent(
                this,
                    new UserCreatedStrategy(),
                    user.getUsername(),
                    user.getEmail()
                )
        );

        return ResponseEntity.created(URI.create("/api/users/")).build();
    }
}