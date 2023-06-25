package hexagonal.architecture.context.application;

import hexagonal.architecture.context.domain.ContextModel;
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
    public void save(ContextModel model) {
        this.repository.save(model);
    }

    @Override
    public List<ContextModel> getAllContexts() {
        return this.repository.findAll();
    }

    @Override
    public ContextName getContextName(ContextModel model) {

        var name = this.repository.getContextName(model.name());

        return factory.createContextName(name);
    }
}
