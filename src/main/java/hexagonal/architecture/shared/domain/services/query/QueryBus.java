package hexagonal.architecture.shared.domain.services.query;

import hexagonal.architecture.shared.domain.model.query.Query;

/**
 * QueryBus generico
 */
@FunctionalInterface
public interface QueryBus {
    <T> T ask(Query query) throws RuntimeException;

}
