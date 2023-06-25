package com.architecture.reactive.context.domain;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ContextModel {
    private String contextName;
}
