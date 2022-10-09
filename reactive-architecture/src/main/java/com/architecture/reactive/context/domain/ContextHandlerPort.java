package com.architecture.reactive.context.domain;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface ContextHandlerPort {

     Mono<ServerResponse> helloWorld(ServerRequest request);
     Mono<ServerResponse> saveContext(ServerRequest request);
     Mono<ServerResponse> getAll(ServerRequest request);
}
