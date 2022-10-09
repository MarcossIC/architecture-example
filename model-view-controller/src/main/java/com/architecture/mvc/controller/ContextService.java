package com.architecture.mvc.controller;

import com.architecture.mvc.model.entity.Context;
import com.architecture.mvc.model.ContextModel;
import com.architecture.mvc.model.ServicePort;
import org.springframework.stereotype.Component;

@Component
public class ContextService implements ServicePort {

    public ContextModel getContext(){
        var context = Context.toModel(
                new Context(1L, "Marcos", "I am developer"));
        return context;
    }
}
