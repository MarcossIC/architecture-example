package hexagonal.architecture.cqrs.product.domain.repositories;

import hexagonal.architecture.cqrs.product.domain.models.Product;

import java.util.Set;

public interface ProductRepository {
    Product save(final Product model);

    void update(final Product product);

    Set<Product> getAllUsers();
}
