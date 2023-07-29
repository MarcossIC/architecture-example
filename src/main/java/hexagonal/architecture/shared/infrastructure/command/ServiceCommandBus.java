package hexagonal.architecture.shared.infrastructure.command;


import hexagonal.architecture.shared.domain.command.Command;
import hexagonal.architecture.shared.domain.command.CommandBus;
import hexagonal.architecture.shared.domain.command.CommandHandler;
import hexagonal.architecture.shared.infrastructure.HandlerMethodFinder;
import hexagonal.architecture.shared.infrastructure.command.exception.CommandHandlerExecutionError;
import hexagonal.architecture.shared.infrastructure.command.exception.CommandNotRegisteredError;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementacion del Command Bus
 * Un Bus, es una clase que se encarga de decidir entre una lista de Eventos
 * Cual es el que debe ejecutar
 */
@Service
@Primary
public class ServiceCommandBus implements CommandBus {
    private final Map<Class, CommandHandler> handlers;


    /**
     * Utilizando funciones de Java Reflections y Dependency Injection
     * Se carga un mapa con los Handler y el Comando al que pertenece
     *
     * @param handlers Lista con todos las implementaciones de CommandHandler (Spring DI)
     */
    public ServiceCommandBus(List<CommandHandler> handlers) {
        this.handlers = new HashMap<>();
        handlers.forEach(commandHandler -> {
            HandlerMethodFinder<CommandHandler, Command> finder = HandlerMethodFinder.searchMethods(commandHandler);
            Class<? extends Command> commandClass = finder.findClass(
                    finder.filterByHandleMethods().filterByParamTerm("Command").getFirstParamClassName()
            ).orElseThrow(RuntimeException::new);
            this.handlers.put(commandClass, commandHandler);
        });
    }

    /**
     * Lleva el comando y ejecuta la accion
     *
     * @param command Comando que se desea ejecutar
     * @throws Exception
     */
    @Override
    public void dispatch(Command command) {
        try {
            var commandHandler = searchHandler(command);
            commandHandler.handle(command);
        } catch (Throwable e) {
            throw new CommandHandlerExecutionError(e);
        }
    }

    /**
     * Ejecuta el comando, sin dar respuesta
     *
     * @param command Comando
     * @return Retorna la clase del Handler
     * @throws CommandNotRegisteredError
     */
    public CommandHandler searchHandler(Command command) throws CommandNotRegisteredError {
        if (!handlers.containsKey(command.getClass()))
            throw new CommandNotRegisteredError(command.getClass());

        var commandHandlerClass = handlers.get(command.getClass());
        return commandHandlerClass;
    }
}
