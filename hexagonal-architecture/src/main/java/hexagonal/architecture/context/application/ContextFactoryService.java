package hexagonal.architecture.context.application;

import hexagonal.architecture.context.domain.ContextModel;
import hexagonal.architecture.context.domain.ContextName;
import hexagonal.architecture.context.domain.ports.ContextFactory;
import hexagonal.architecture.context.infrastructure.ContextEntity;
import org.springframework.stereotype.Component;

@Component
public final class ContextFactoryService implements ContextFactory {

    @Override
    public ContextName createContextName(String name) {
        return ContextName.builder()
                .name(name)
                .build();
    }

    @Override
    public ContextModel createContextModel(String name) {
        return ContextModel.builder()
                .name(name)
                .build();
    }

    @Override
    public ContextEntity createContextEntity(ContextModel model) {
        return ContextEntity.builder()
                .contextName(model.name())
                .build();
    }

    @Override
    public ContextEntity createContextEntity(String name) {
        return ContextEntity.builder()
                .contextName(name)
                .build();
    }
}
