package com.architecture.reactive.context.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("context")
/**
 * This is an entity in your context
 */
public class Context implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    @NotNull
    private Long contextId;

    @NotEmpty
    @Column("name")
    private String contextName;

    public static Context toEntity(ContextModel model){
        return Context.builder()
                .contextName(model.getContextName())
                .build();
    }

}
