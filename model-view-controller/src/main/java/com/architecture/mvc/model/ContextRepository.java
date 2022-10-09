package com.architecture.mvc.model;

import com.architecture.mvc.model.entity.Context;
import org.springframework.data.repository.CrudRepository;

public interface ContextRepository extends CrudRepository<Context, Long> {
}
