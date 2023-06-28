package hexagonal.architecture.context.infrastructure.persistence;

import hexagonal.architecture.context.domain.Context;
import hexagonal.architecture.context.domain.ports.ContextRepository;
import hexagonal.architecture.context.infrastructure.ContextEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/*Clase adaptadora (Patron Adapter)*/
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public final class ContextJpaRepositoryAdapter implements ContextRepository {
    private final ContextJpaRepository jpaRepository;

    @Override
    public void save(Context model) {
        jpaRepository.saveAndFlush(new ContextEntity(model));
    }

    @Override
    public Optional<String> getContextName(String id) {
        return jpaRepository.findContextNameById(Long.parseLong(id));
    }

    @Override
    public List<Context> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(ContextEntity::toModel)
                .toList();
    }

}
