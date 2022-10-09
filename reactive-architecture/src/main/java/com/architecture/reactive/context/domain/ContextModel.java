package com.architecture.reactive.context.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Builder
@Getter
@AllArgsConstructor
public class ContextModel {
    @NotEmpty
    private String contextName;
}
