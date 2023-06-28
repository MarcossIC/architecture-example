package hexagonal.architecture.context.infrastructure.persistence;

import hexagonal.architecture.context.infrastructure.ContextEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ContextJpaRepository extends JpaRepository<ContextEntity, Long> {

    Optional<String> findContextNameById(Long id);
}
