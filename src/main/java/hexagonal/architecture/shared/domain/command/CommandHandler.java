package hexagonal.architecture.shared.domain.command;

public interface CommandHandler<T extends Command> {
    void handle(T command);
}
