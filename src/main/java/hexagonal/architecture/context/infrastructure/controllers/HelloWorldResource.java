package hexagonal.architecture.context.infrastructure.controllers;

import hexagonal.architecture.context.domain.ports.ContextServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HelloWorldResource {
    public final ContextServicePort service;

    @GetMapping("/hello-world")
    public HttpEntity<String> getHello() {
        return ok().body(service.getHelloWorld());
    }
}
