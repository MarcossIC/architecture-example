package hexagonal.architecture.context.domain.ports;

import hexagonal.architecture.context.domain.ContextModel;
import hexagonal.architecture.context.domain.ContextName;

import java.util.List;

public interface ContextServicePort {


    String getHelloWorld();

    void save(ContextModel name);

    List<ContextModel> getAllContexts();

    ContextName getContextName(ContextModel model);
}
