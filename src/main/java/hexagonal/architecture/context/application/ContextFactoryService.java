package hexagonal.architecture.context.application;

import hexagonal.architecture.context.domain.ContextName;
import hexagonal.architecture.context.domain.ports.ContextFactory;
import org.springframework.stereotype.Component;

@Component
public final class ContextFactoryService implements ContextFactory {
    @Override
    public ContextName createContextName(String name) {
        return ContextName.builder()
                .name(name)
                .build();
    }
}
