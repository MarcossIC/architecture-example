package hexagonal.architecture.shared.domain.services.command;

import hexagonal.architecture.shared.domain.model.Command;

public interface CommandHandler<T extends Command> {
    void handle(T command);
}
