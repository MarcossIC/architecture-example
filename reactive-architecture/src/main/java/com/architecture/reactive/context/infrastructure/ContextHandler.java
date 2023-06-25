package com.architecture.reactive.context.infrastructure;

import com.architecture.reactive.context.domain.Context;
import com.architecture.reactive.context.domain.ports.ContextHandlerPort;
import com.architecture.reactive.context.domain.ports.ContextMapper;
import com.architecture.reactive.context.domain.ContextModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContextHandler implements ContextHandlerPort {
    private final ContextMapper mapper;
    private final ContextRepository repository;
    private final Mono<ServerResponse> notFound = ServerResponse.notFound().build();

    @Override
    public Mono<ServerResponse> helloWorld(ServerRequest request){
        return ServerResponse.status(HttpStatus.OK)
                .body(Mono.just("Hello World"), String.class);
    }

    @Override
    public Mono<ServerResponse> saveContext(ServerRequest request) {
        var name = request.queryParam("name");

        Mono.just( mapper.mapContext( ContextModel.builder()
                        .contextName(name.orElse(""))
                        .build()))
                .map(repository::save)
                .subscribeOn(Schedulers.single());

        return ServerResponse
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(repository.findAll()
                        .subscribeOn(Schedulers.parallel())
                        .delayElements(Duration.ofMillis(3))
                        .switchIfEmpty(Flux.empty()), Context.class)
                .log();
    }

}
