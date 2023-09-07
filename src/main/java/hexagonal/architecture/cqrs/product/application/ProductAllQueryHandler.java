package hexagonal.architecture.cqrs.product.application;

import hexagonal.architecture.cqrs.product.domain.models.dto.ProductList;
import hexagonal.architecture.cqrs.product.domain.models.query.ProductAllQuery;
import hexagonal.architecture.cqrs.product.domain.repositories.ProductRepository;
import hexagonal.architecture.shared.domain.services.query.QueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductAllQueryHandler implements QueryHandler<ProductAllQuery, ProductList> {
    private final ProductRepository repository;

    @Override
    public ProductList handle(ProductAllQuery query) throws Exception {
        return ProductList.builder()
                .products(this.repository.getAllUsers())
                .build();
    }
}
