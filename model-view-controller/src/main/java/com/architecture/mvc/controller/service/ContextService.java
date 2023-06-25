package com.architecture.mvc.controller.service;

import com.architecture.mvc.controller.interfaces.ContextMapper;
import com.architecture.mvc.model.entity.Context;
import com.architecture.mvc.model.ContextModel;
import com.architecture.mvc.controller.interfaces.ServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContextService implements ServicePort {

    private ContextMapper mapper;

    public ContextModel getContext(){
        return mapper.mapContextModel(Context.builder()
                .id(1L)
                .name("Marcos")
                .description("I am developer")
                .build());<;
    }
}
