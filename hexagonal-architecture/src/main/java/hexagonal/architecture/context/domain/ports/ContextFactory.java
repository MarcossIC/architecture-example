package hexagonal.architecture.context.domain.ports;

import hexagonal.architecture.context.domain.ContextModel;
import hexagonal.architecture.context.domain.ContextName;
import hexagonal.architecture.context.infrastructure.ContextEntity;

public interface ContextFactory {

    ContextName createContextName(String name);

    ContextModel createContextModel(String name);

    ContextEntity createContextEntity(ContextModel model);

    ContextEntity createContextEntity(String name);
}
