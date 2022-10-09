package com.architecture.mvc.model;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Getter
public class ContextModel {
    @NotNull
    private Long contextId;
    @NotEmpty
    private String contextName;
    @NotEmpty
    private String contextDescription;
}
