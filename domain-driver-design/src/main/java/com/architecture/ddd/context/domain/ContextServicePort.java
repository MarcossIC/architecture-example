package com.architecture.ddd.context.domain;

import java.util.List;

public interface ContextServicePort {
    String getHelloWorld();
    void save(String name);
    List<Context> getAll();

}
