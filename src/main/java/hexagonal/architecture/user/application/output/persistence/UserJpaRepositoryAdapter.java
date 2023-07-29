package hexagonal.architecture.user.application.output.persistence;

import hexagonal.architecture.user.domain.model.User;
import hexagonal.architecture.user.application.input.dto.UserSaveDTO;
import hexagonal.architecture.user.infrastructure.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/*Clase adaptadora (Patron Adapter)*/
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public final class UserJpaRepositoryAdapter implements UserRepository {
    private final UserJpaRepository jpaRepository;

    @Override
    public User save(UserSaveDTO model) {
        var entity = jpaRepository.saveAndFlush(UserEntity.saveModelToEntity(model));
        return entity.toModel();
    }

    @Override
    public List<User> getAllUsers() {
        return jpaRepository.findAll()
                .stream()
                .map(UserEntity::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean emailAlreadyExists(String email) {
        return jpaRepository.existsByEmail(email);
    }
}
