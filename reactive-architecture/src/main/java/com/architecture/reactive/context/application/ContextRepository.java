package com.architecture.reactive.context.application;

import com.architecture.reactive.context.domain.Context;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextRepository extends ReactiveSortingRepository<Context, Long> {

}
