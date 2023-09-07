package hexagonal.architecture.cqrs.product.infrastructure.persistence;

import hexagonal.architecture.cqrs.product.domain.models.Product;
import hexagonal.architecture.cqrs.product.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProductJpaRepositoryAdapter implements ProductRepository {
    private final ProductJpaRepository jpaRepository;

    @Override
    public Product save(Product model) {
        if (model == null) throw new IllegalArgumentException("The parameter in the repository cannot be null");
        return jpaRepository
                .save(ProductEntity.modelToEntity(model))
                .entityToModel();
    }

    @Override
    public void update(Product model) {
        if (model == null) throw new IllegalArgumentException("The parameter in the repository cannot be null");
        jpaRepository.findById(Long.valueOf(model.getId()))
                .flatMap(product -> {
                    product.setName( Optional.of(model.getName()).orElse(product.getName()) );
                    product.setPrice( Optional.of(model.getPrice()).orElse(product.getPrice()) );
                    return Optional.of(product);
                }).orElseThrow(() -> {
                    throw new RuntimeException("User ID " + model.getId() + " is not registered");
                });
    }

    @Override
    public Set<Product> getAllUsers() {
        return jpaRepository.findAll()
                .stream()
                .map(ProductEntity::entityToModel)
                .collect(Collectors.toUnmodifiableSet());
    }
}
