package hexagonal.architecture.shared.domain.services.query;

import hexagonal.architecture.shared.domain.model.Query;
import hexagonal.architecture.shared.domain.model.Response;

/**
 * QueryHandler Generico
 */
@FunctionalInterface
public interface QueryHandler<Q extends Query, R extends Response> {

    R handle(Q query) throws Exception;
}
