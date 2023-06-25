package com.architecture.reactive.context.application;

import com.architecture.reactive.context.domain.Context;
import com.architecture.reactive.context.domain.ports.ContextMapper;
import com.architecture.reactive.context.domain.ContextModel;
import org.springframework.stereotype.Component;

@Component
public final class ContextMapperService implements ContextMapper {
    @Override
    public Context mapContext(ContextModel model) {
        return Context.builder()
                .contextName(model.getContextName())
                .build();
    }

}
