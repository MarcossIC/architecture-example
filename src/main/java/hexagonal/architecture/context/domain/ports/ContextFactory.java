package hexagonal.architecture.context.domain.ports;

import hexagonal.architecture.context.domain.ContextName;

public interface ContextFactory {

    ContextName createContextName(String name);
}
