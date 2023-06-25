package com.architecture.mvc.model;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Value
public class ContextModel {
    @NotNull
    private Long contextId;
    @NotEmpty
    private String contextName;
    @NotEmpty
    private String contextDescription;
}
