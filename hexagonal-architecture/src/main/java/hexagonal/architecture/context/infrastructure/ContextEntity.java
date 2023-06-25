package hexagonal.architecture.context.infrastructure;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;


/**
 * This is an entity in your context
 */
@Entity
@Builder
@Data

public class ContextEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contextId;

    @Column(name = "name")
    private String contextName;
}
