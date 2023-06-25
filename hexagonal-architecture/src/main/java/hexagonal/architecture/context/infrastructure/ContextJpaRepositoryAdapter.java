package hexagonal.architecture.context.infrastructure;

import hexagonal.architecture.context.domain.ContextModel;
import hexagonal.architecture.context.domain.ports.ContextFactory;
import hexagonal.architecture.context.domain.ports.ContextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContextJpaRepositoryAdapter implements ContextRepository {
    private final ContextJpaRepository jpaRepository;
    private final ContextFactory factory;

    @Override
    public void save(ContextModel model) {
        jpaRepository.saveAndFlush(factory.createContextEntity(model));
    }

    @Override
    public String getContextName(String id) {
        var name = jpaRepository.findContextNameByContextId(Long.parseLong(id));

        return name.orElse("");
    }

    @Override
    public List<ContextModel> findAll() {
        return null;
    }

}
