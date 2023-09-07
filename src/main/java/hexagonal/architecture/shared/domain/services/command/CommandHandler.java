package hexagonal.architecture.shared.domain.services.command;

import hexagonal.architecture.shared.domain.model.command.Command;

public interface CommandHandler<T extends Command> {
    void handle(T command);
}
