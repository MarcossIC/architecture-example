package hexagonal.architecture.shared.infrastructure.query;

import hexagonal.architecture.shared.domain.model.query.Query;
import hexagonal.architecture.shared.domain.model.query.Response;
import hexagonal.architecture.shared.domain.services.query.QueryBus;
import hexagonal.architecture.shared.domain.services.query.QueryHandler;
import hexagonal.architecture.shared.domain.util.HandlerMethodFinder;
import hexagonal.architecture.shared.infrastructure.query.exception.QueryHandlerExecutionError;
import hexagonal.architecture.shared.infrastructure.query.exception.QueryNotRegisteredError;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * clase que decide que implementacion de los query handler debe ejecutar
 * Implementacion de {@link QueryBus}
 */
@Service
@Primary
public class ServiceQueryBus implements QueryBus {
    private final Map<Class, QueryHandler> queryHandlers;


    /**
     * Carga todos los Comandos y handler en un mapa de datos
     *
     * @param query Lista con todos las implementaciones de CommandHandler (Spring DI)
     */
    public ServiceQueryBus(List<QueryHandler> query) {

        this.queryHandlers = new HashMap<>();
        query.forEach(queryHandler -> {
            HandlerMethodFinder<QueryHandler, Query> finder = HandlerMethodFinder.searchMethods(queryHandler);
            Class<? extends Query> queryClass = finder.findClass(
                    finder.filterByHandleMethods().filterByParamTerm("Query").getFirstParamClassName()
            ).orElseThrow(RuntimeException::new);
            this.queryHandlers.put(queryClass, queryHandler);
        });
    }


    /**
     * Hace la consulta y devuelve el valor consultado
     *
     * @param query Consulta con la informacion para recuperar los datos
     * @return Devuelva una respuesta a la consulta
     * @throws QueryHandlerExecutionError
     */
    @Override
    public Response ask(Query query) throws RuntimeException {
        try {
            var handler = this.search(query);
            return handler.handle(query);
        } catch (Throwable error) {
            throw new QueryHandlerExecutionError(error);
        }
    }

    private QueryHandler search(Query query) throws QueryNotRegisteredError {
        var queryHandlerClass = queryHandlers.get(query.getClass());

        if (null == queryHandlerClass) {
            throw new QueryNotRegisteredError(query.getClass());
        }
        return queryHandlerClass;
    }
}
