package hexagonal.architecture.cqrs.product.domain.models.dto;

import hexagonal.architecture.cqrs.product.domain.models.Product;
import hexagonal.architecture.shared.domain.model.query.Response;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
public class ProductList implements Response {
    private Set<Product> products;

    public Set<Product> getProducts() {
        return products;
    }
}
