package com.architecture.reactive.context.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class ContextRouter {

    @Bean
    public RouterFunction<ServerResponse> contextRouterFunction(ContextHandler handler){
        return nest(path("/api/contexts"), nest(accept(APPLICATION_JSON).or(contentType(APPLICATION_JSON)),
                route(POST(""),
                        handler::saveContext)
                .andRoute(GET(""),
                        handler::getAll)
                .andRoute(GET("/hello-world"),
                                    handler::helloWorld))
        );
    }
}
