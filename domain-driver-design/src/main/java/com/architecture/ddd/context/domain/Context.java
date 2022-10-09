package com.architecture.ddd.context.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
/**
 * This is an entity in your context
 */
public class Context implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    private Long contextId;
    @Column(name = "name")
    private String contextName;

    public static Context toEntity(String name){
        return Context.builder()
                .contextName(name)
                .build();
    }

}
