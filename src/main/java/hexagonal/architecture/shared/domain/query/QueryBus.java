package hexagonal.architecture.shared.domain.query;

/**
 * QueryBus generico
 */
@FunctionalInterface
public interface QueryBus {
    <T> T ask(Query query) throws RuntimeException;

}
