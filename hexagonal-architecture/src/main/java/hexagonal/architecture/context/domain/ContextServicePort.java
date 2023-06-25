package hexagonal.architecture.context.domain;

import hexagonal.architecture.context.infrastructure.ContextJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class ContextServicePort {
    @Autowired
    protected ContextJpaRepository repository;

    public abstract String getHelloWorld();
    public abstract void save(String name);
    public abstract List<Context> getAll();

    public abstract <T> T getContextName(String id);

}
