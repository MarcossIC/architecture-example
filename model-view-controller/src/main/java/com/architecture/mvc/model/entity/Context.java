package com.architecture.mvc.model.entity;

import com.architecture.mvc.model.ContextModel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Builder
@Data
public class Context implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    public Context(Long id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
