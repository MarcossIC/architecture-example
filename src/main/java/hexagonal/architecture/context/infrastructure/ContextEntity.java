package hexagonal.architecture.context.infrastructure;

import hexagonal.architecture.context.domain.Context;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;


/**
 * This is an entity in your context
 */
@Entity
@Table(name = "context")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContextEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 25, nullable = false)
    private String contextName;

    public ContextEntity(Context model) {
        this.contextName = model.getName();
    }

    public Context toModel() {
        return Context.builder()
                .name(this.contextName)
                .id(this.id.toString())
                .build();
    }


}
