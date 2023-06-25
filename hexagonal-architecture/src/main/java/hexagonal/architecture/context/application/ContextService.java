package hexagonal.architecture.context.application;

import hexagonal.architecture.context.domain.Context;
import hexagonal.architecture.context.domain.ContextMapper;
import hexagonal.architecture.context.domain.ContextName;
import hexagonal.architecture.context.domain.ContextServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public final class ContextService extends ContextServicePort {
    public ContextMapper mapper;

    @Override
    public String getHelloWorld() {
        return "Hello World";
    }

    @Override
    public void save(String name) {
        this.repository.save(Context.toEntity(name));
    }

    @Override
    public List<Context> getAll() {
        return this.repository.findAll();
    }

    @Override
    public ContextName getContextName(String id) {
        var name = this.repository.getContextName(Long.parseLong(id));
        return mapper.mapContextName(name.orElse(""));
    }
}
