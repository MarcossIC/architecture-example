package hexagonal.architecture.user.infrastructure.persistence;

import hexagonal.architecture.user.domain.repository.UserRepository;
import hexagonal.architecture.user.domain.model.User;
import hexagonal.architecture.user.domain.model.dto.UserSaveDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Clase adaptadora permite tener una capa mas entre la aplicacion y JPA
 * Esto me sirve para estar desacoplado de JPA
 */
@Repository
@RequiredArgsConstructor
public final class UserJpaRepositoryAdapter implements UserRepository {
    //Repositorio con los metodos de jpa
    private final UserJpaRepository jpaRepository;

    //Otra forma de hacer el mapeo
    private final Function<UserEntity, User> entityToModel = entity-> User.builder()
            .id(entity.getId().toString())
            .username(entity.getUsername())
            .email(entity.getEmail())
            .password(entity.getPassword())
            .build();

    @Override
    public User save(UserSaveDTO model) {
        var entity = jpaRepository.saveAndFlush(UserEntity.saveModelToEntity(model));
        //Transformo la entidad a modelo
        return entity.toModel();
    }

    @Override
    public List<User> getAllUsers() {
        return jpaRepository.findAll()
                .stream()
                //.map(entityToModel::apply)
                .map(UserEntity::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean emailAlreadyExists(String email) {
        return jpaRepository.existsByEmail(email);
    }
}
