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
import java.io.Serial;
import java.io.Serializable;

/**
 * This is an entity in your context
 */
@Data
@Builder
@Table("context")

public class Context implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long contextId;

    @Column("name")
    private String contextName;

}
