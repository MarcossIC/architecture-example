package hexagonal.architecture.context.domain.ports;

import hexagonal.architecture.context.domain.ContextModel;

import java.util.List;

public interface ContextRepository {

    void save(ContextModel model);

    String getContextName(String id);

    List<ContextModel> findAll();
}
