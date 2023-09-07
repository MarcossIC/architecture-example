package hexagonal.architecture.shared.domain.mapper;

@FunctionalInterface
public interface AbstractMapper<V, R> {
    R map(V value);
}
