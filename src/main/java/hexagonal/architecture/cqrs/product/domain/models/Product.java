package hexagonal.architecture.cqrs.product.domain.models;

import hexagonal.architecture.shared.domain.model.query.Response;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Builder
@Data
public final class Product implements Response {
    private final String id;
    private final String name;
    private final Integer price;
}
