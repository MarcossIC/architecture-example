package com.architecture.mvc.model.entity;

import com.architecture.mvc.model.ContextModel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Builder
@Getter
@NoArgsConstructor
public class Context implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    private Long contextId;
    @NotEmpty
    private String contextName;
    @NotEmpty
    private String contextDescription;

    public Context(Long contextId, String contextName, String contextDescription) {
        super();
        this.contextId = contextId;
        this.contextName = contextName;
        this.contextDescription = contextDescription;
    }

    public static ContextModel toModel(Context context){
        return ContextModel.builder()
                .contextId(context.getContextId())
                .contextName(context.getContextName())
                .contextDescription(context.getContextDescription())
                .build();
    }
}
