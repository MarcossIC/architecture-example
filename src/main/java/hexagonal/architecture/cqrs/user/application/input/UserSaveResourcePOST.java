package hexagonal.architecture.cqrs.user.application.input;

import hexagonal.architecture.cqrs.user.application.input.commands.UserSaveCommand;
import hexagonal.architecture.cqrs.user.application.output.email.UserSavedEvent;
import hexagonal.architecture.cqrs.user.infrastructure.UserCreatedStrategy;
import hexagonal.architecture.shared.domain.command.CommandHandler;
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
public final class UserSaveResourcePOST {
    private final CommandHandler<UserSaveCommand> saveHandler;
    private final ApplicationEventPublisher publisher;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Void> saveUser(@RequestBody @Valid UserSaveCommand command) {
        saveHandler.handle(command);

        publisher.publishEvent(new UserSavedEvent(
                this,
                    new UserCreatedStrategy(),
                    command.getUsername(),
                    command.getEmail()
                )
        );

        return ResponseEntity.created(URI.create("/api/users/")).build();
    }
}