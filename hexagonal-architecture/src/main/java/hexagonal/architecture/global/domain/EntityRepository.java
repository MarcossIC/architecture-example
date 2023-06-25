package hexagonal.architecture.global.domain;

import java.util.List;
public interface EntityRepository {
    <T> T save(T entity);

    <T> T getById(String id, Class<T> clazz);

    <T> List<T> getAll(Class<T> clazz);
}
