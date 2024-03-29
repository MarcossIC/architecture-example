package hexagonal.architecture.shared.infrastructure.command.exception;

import hexagonal.architecture.shared.domain.model.command.Command;

public final class CommandNotRegisteredError extends Exception {
    public CommandNotRegisteredError(Class<? extends Command> command) {
        super(String.format("The command <%s> hasn't a command handler associated", command.toString()));
    }
}
