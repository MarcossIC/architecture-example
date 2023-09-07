package hexagonal.architecture.cqrs.product.domain.models.query;

import hexagonal.architecture.shared.domain.model.query.Query;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class ProductAllQuery implements Query {
}
