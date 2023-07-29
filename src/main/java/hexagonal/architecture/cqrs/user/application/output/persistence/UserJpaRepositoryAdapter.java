package hexagonal.architecture.cqrs.user.application.output.persistence;

import hexagonal.architecture.cqrs.user.application.input.commands.UserSaveCommand;
import hexagonal.architecture.cqrs.user.domain.model.User;
import hexagonal.architecture.cqrs.user.infrastructure.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/*Clase adaptadora (Patron Adapter)*/
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public final class UserJpaRepositoryAdapter implements UserRepository {
    private final UserJpaRepository jpaRepository;

    @Override
    public User save(UserSaveCommand model) {
        var entity = jpaRepository.saveAndFlush(UserEntity.saveModelToEntity(model));
        return entity.toModel();
    }

    @Override
    public Set<User> getAllUsers() {
        return jpaRepository.findAll()
                .stream()
                .map(UserEntity::toModel)
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Boolean emailAlreadyExists(String email) {
        return jpaRepository.existsByEmail(email);
    }
}
