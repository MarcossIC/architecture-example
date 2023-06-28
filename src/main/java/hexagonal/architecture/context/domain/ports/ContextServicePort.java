package hexagonal.architecture.context.domain.ports;

import hexagonal.architecture.context.domain.Context;
import hexagonal.architecture.context.domain.ContextIdModel;
import hexagonal.architecture.context.domain.ContextName;

import java.util.List;

public interface ContextServicePort {


    String getHelloWorld();

    void save(Context name);

    List<Context> getAllContexts();

    ContextName getContextName(ContextIdModel model);
}
