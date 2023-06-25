package com.architecture.reactive.context.domain.ports;

import com.architecture.reactive.context.domain.Context;
import com.architecture.reactive.context.domain.ContextModel;

public interface ContextMapper {

    Context mapContext(ContextModel model) ;
}
