package hexagonal.architecture.shared.domain.command;

import hexagonal.architecture.shared.infrastructure.command.exception.CommandHandlerExecutionError;

public interface CommandBus {
    void dispatch(Command command) throws CommandHandlerExecutionError;
}
