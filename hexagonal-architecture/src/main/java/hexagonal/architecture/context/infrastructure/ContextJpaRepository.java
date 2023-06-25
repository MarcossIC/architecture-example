package hexagonal.architecture.context.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContextJpaRepository extends JpaRepository<ContextEntity, Long> {

    Optional<String> findContextNameByContextId(Long id);
}
