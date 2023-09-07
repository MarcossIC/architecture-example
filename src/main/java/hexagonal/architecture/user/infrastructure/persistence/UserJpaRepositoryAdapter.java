package hexagonal.architecture.user.infrastructure.persistence;

import hexagonal.architecture.user.domain.models.User;
import hexagonal.architecture.user.domain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * Clase adaptadora permite tener una capa mas entre la aplicacion y JPA
 * Esto me sirve para estar desacoplado de JPA
 */
@Repository
@RequiredArgsConstructor
public class UserJpaRepositoryAdapter implements UserRepository {
    //Repositorio con los metodos de jpa
    private final UserJpaRepository jpaRepository;

    @Override
    public User save(User model) {
        if (model == null) throw new IllegalArgumentException("The parameter in the repository cannot be null");
        return jpaRepository
                .save(UserEntity.modelToEntity(model))
                .toModel();
    }

    @Override
    public void update(User model, String oldPassword) {
        if (model == null) throw new IllegalArgumentException("The parameter in the repository cannot be null");

        jpaRepository.findById(Long.valueOf(model.getId()))
                .flatMap(user -> {

                    user.setUsername(
                            Optional.of( model.getUsername() )
                                    .filter(username-> !user.getUsername().equals(username))
                                    .filter(this::usernameIsNotInUse)
                                    .orElse(user.getUsername())
                    );
                    user.setEmail(
                            Optional.of( model.getEmail() )
                                    .filter(email-> !email.equals(user.getEmail()) )
                                    .filter(this::emailIsNotInUse)
                                    .orElse(user.getEmail())
                    );
                    user.setPassword(
                            Optional.of( model.getPassword() )
                                    .filter(password-> !password.equals(user.getPassword()))
                                    .filter(password-> !oldPassword.equals(password))
                                    .filter(password-> oldPassword.equals(user.getPassword()))
                                    .orElse(user.getPassword())
                    );
                    return Optional.of(user);
                }).orElseThrow(() -> {
                    throw new RuntimeException("User ID " + model.getId() + " is not registered");
                });

    }

    private Boolean usernameIsNotInUse(String username){
        return !jpaRepository.existsByUsername(username);
    }

    private Boolean emailIsNotInUse(String email){
        return !jpaRepository.existsByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return jpaRepository.findAll()
                .stream()
                .map(UserEntity::toModel)
                .toList();
    }
}
