package hexagonal.architecture.shared.domain.services.command;

import hexagonal.architecture.shared.domain.model.Command;
import hexagonal.architecture.shared.infrastructure.command.exception.CommandHandlerExecutionError;

public interface CommandBus {
    void dispatch(Command command) throws CommandHandlerExecutionError;
}
