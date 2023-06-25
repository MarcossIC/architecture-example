package hexagonal.architecture.context.infrastructure.controllers;

import hexagonal.architecture.context.domain.ports.ContextFactory;
import hexagonal.architecture.context.domain.ports.ContextServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/contexts")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SaveContextResource {
    private final ContextServicePort service;
    private final ContextFactory factory;

    @PostMapping("/{name}")
    public HttpEntity<Void> saveContext(@PathVariable String name) {
        service.save(factory.createContextModel(name));

        return ResponseEntity.created(URI.create("http://localhost/api/contexts/" + name)).build();
    }
}
