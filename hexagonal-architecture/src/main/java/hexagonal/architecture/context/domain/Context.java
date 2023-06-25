package hexagonal.architecture.context.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;


/**
 * This is an entity in your context
 */
@Entity
@Builder
@AllArgsConstructor

public class Context implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contextId;

    @Column(name = "name")
    private String contextName;

    public static Context toEntity(String name){
        return Context.builder()
                .contextName(name)
                .build();
    }

}
