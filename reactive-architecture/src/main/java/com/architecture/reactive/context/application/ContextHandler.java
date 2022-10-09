package com.architecture.reactive.context.application;

import com.architecture.reactive.context.domain.Context;
import com.architecture.reactive.context.domain.ContextHandlerPort;
import com.architecture.reactive.context.domain.ContextModel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class ContextHandler  implements ContextHandlerPort {
    @Autowired
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
        Mono.just(Context.toEntity(ContextModel.builder().contextName(name.get()).build()))
                .map(repository::save).subscribeOn(Schedulers.single());

        return ServerResponse
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(repository.findAll()
                        .subscribeOn(Schedulers.parallel())
                        .delayElements(Duration.ofMillis(3))
                        .switchIfEmpty(Flux.empty()), Context.class).log();
    }

}
