package hexagonal.architecture.context.application;

import hexagonal.architecture.context.domain.Context;
import hexagonal.architecture.context.domain.ContextIdModel;
import hexagonal.architecture.context.domain.ContextName;
import hexagonal.architecture.context.domain.ports.ContextFactory;
import hexagonal.architecture.context.domain.ports.ContextRepository;
import hexagonal.architecture.context.domain.ports.ContextServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public final class ContextService implements ContextServicePort {

    private final ContextRepository repository;
    private final ContextFactory factory;

    @Override
    public String getHelloWorld() {
        return "Hello World";
    }

    @Override
    public void save(Context model) {
        this.repository.save(model);
    }

    @Override
    public List<Context> getAllContexts() {
        return this.repository.findAll();
    }

    @Override
    public ContextName getContextName(ContextIdModel model) {

        var name = this.repository.getContextName(model.id());

        return factory.createContextName(name.orElse(""));
    }
}
