package com.architecture.ddd.context.application;

import com.architecture.ddd.context.domain.Context;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextRepository extends JpaRepository<Context, Long> {
}
