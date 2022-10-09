package com.architecture.ddd.context.application;

import com.architecture.ddd.context.domain.Context;
import com.architecture.ddd.context.domain.ContextServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContextService implements ContextServicePort {
    @Autowired
    private ContextRepository repository;

    @Override
    public String getHelloWorld() {
        return "Hello World";
    }

    @Override
    public void save(String name) {
        repository.save(Context.toEntity(name));
    }

    @Override
    public List<Context> getAll() {
        return repository.findAll();
    }
}
