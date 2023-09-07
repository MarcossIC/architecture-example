package hexagonal.architecture.cqrs.product.infrastructure.persistence;

import hexagonal.architecture.cqrs.product.domain.models.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;


/**
 * This is an entity in your context
 */
@Entity
@Table(name = "product", schema = "example")
@Builder
@Data
public class ProductEntity implements Serializable {

    @Id
    @Column(name = "id", columnDefinition = "INT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 70, nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    public static ProductEntity modelToEntity(Product model) {
        return ProductEntity.builder()
                .name(Optional.of( model.getName() ).orElse(""))
                .price(Optional.of( model.getPrice() ).orElse(0))
                .build();
    }

    public Product entityToModel() {
        return Product.builder()
                .id(this.getId().toString())
                .name(Optional.of( this.getName() ).orElse(""))
                .price(Optional.of( this.getPrice() ).orElse(0))
                .build();
    }
}
