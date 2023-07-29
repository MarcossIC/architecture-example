package hexagonal.architecture.cqrs.user.infrastructure;

import hexagonal.architecture.cqrs.user.application.output.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    Boolean existsByEmail(String email);
    UserEntity findUsById(Long id);
}
