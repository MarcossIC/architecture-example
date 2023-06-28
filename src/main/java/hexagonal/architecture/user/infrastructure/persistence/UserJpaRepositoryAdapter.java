package hexagonal.architecture.user.infrastructure.persistence;

import hexagonal.architecture.user.domain.UserModel;
import hexagonal.architecture.user.domain.UserSaveModel;
import hexagonal.architecture.user.domain.ports.UserRepository;
import hexagonal.architecture.user.infrastructure.UserEntity;
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
    public UserModel save(UserSaveModel model) {
        var entity = jpaRepository.saveAndFlush(UserEntity.saveModelToEntity(model));
        return entity.toModel();
    }
    @Override
    public List<UserModel> getAllUsers() {
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
