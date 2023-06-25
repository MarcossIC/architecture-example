package hexagonal.architecture.context.infrastructure.controllers;

import hexagonal.architecture.context.domain.ports.ContextServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api")
public class HelloWorldResource {
    public ContextServicePort service;

    @Autowired
    public HelloWorldResource(ContextServicePort service) {
        this.service = service;
    }

    @GetMapping("/hello-world")
    public HttpEntity<String> getHello() {
        return ok().body(service.getHelloWorld());
    }
}
