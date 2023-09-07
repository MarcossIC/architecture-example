package hexagonal.architecture.user.infrastructure.controller;

import hexagonal.architecture.user.domain.events.UserSavedEvent;
import hexagonal.architecture.user.domain.models.dto.SaveUserDTO;
import hexagonal.architecture.user.domain.usecase.SaveUserUseCase;
import hexagonal.architecture.user.domain.util.UserCreatedStrategyEmail;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public final class SaveUserController {
    private final SaveUserUseCase service;
    private final ApplicationEventPublisher publisher;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Void> saveUser(@RequestBody @Valid SaveUserDTO model) {
        var user = service.save(model);

        publisher.publishEvent(new UserSavedEvent(
                        this,
                        new UserCreatedStrategyEmail(),
                        user.getUsername(),
                        user.getEmail()
                )
        );

        return ResponseEntity.created(URI.create("/api/v1/users/")).build();
    }
}