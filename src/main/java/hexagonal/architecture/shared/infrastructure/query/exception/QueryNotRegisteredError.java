package hexagonal.architecture.shared.infrastructure.query.exception;

import hexagonal.architecture.shared.domain.query.Query;

public final class QueryNotRegisteredError extends Exception {
    public QueryNotRegisteredError(Class<? extends Query> query) {
        super(String.format("The query <%s> hasn't a query handler associated", query.toString()));
    }
}
