package com.architecture.mvc.controller.interfaces;

import com.architecture.mvc.model.ContextModel;
import com.architecture.mvc.model.entity.Context;

public interface ContextMapper {

    ContextModel mapContextModel(Context context);
}
