package hexagonal.architecture.context.infrastructure;

import hexagonal.architecture.context.domain.Context;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContextJpaRepository extends JpaRepository<Context, Long> {

    Optional<String> getContextName(Long id);
}
