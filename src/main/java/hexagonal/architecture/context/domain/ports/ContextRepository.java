package hexagonal.architecture.context.domain.ports;

import hexagonal.architecture.context.domain.Context;

import java.util.List;
import java.util.Optional;

public interface ContextRepository {

    void save(Context model);

    Optional<String> getContextName(String id);

    List<Context> findAll();
}
