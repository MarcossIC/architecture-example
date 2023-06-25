package com.architecture.mvc.controller;

import com.architecture.mvc.controller.interfaces.ContextMapper;
import com.architecture.mvc.model.ContextModel;
import com.architecture.mvc.model.entity.Context;
import org.springframework.stereotype.Component;

@Component
public final class ContextMapperService implements ContextMapper {
    @Override
    public ContextModel mapContextModel(Context context) {
        return ContextModel.builder()
                .contextId(context.getId())
                .contextName(context.getName())
                .contextDescription(context.getDescription())
                .build();
    }

}
