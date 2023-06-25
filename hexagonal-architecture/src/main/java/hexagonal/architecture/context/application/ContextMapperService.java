package hexagonal.architecture.context.application;

import hexagonal.architecture.context.domain.ContextMapper;
import hexagonal.architecture.context.domain.ContextName;
import org.springframework.stereotype.Component;

@Component
public final class ContextMapperService implements ContextMapper {
    @Override
    public ContextName mapContextName(String name) {
        return ContextName.builder()
                .name(name)
                .build();
    }

}
