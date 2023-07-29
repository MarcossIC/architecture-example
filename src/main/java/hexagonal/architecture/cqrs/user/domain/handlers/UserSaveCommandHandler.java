package hexagonal.architecture.cqrs.user.domain.handlers;

import hexagonal.architecture.cqrs.user.application.input.commands.UserSaveCommand;
import hexagonal.architecture.cqrs.user.application.output.persistence.UserRepository;
import hexagonal.architecture.shared.domain.command.CommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserSaveCommandHandler implements CommandHandler<UserSaveCommand> {
    private final UserRepository repository;

    @Override
    public void handle(UserSaveCommand command) {
        this.repository.save(command);
    }
}
