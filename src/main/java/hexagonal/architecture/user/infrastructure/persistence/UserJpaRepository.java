package hexagonal.architecture.user.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
