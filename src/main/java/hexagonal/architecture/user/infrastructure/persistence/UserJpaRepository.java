package hexagonal.architecture.user.infrastructure.persistence;

import hexagonal.architecture.user.infrastructure.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    Boolean existsByEmail(String email);
    UserEntity findUsById(Long id);
}
