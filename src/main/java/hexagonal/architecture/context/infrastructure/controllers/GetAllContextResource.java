package hexagonal.architecture.context.infrastructure.controllers;

import hexagonal.architecture.context.domain.Context;
import hexagonal.architecture.context.domain.ports.ContextServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/contexts")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GetAllContextResource {
    public final ContextServicePort service;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<List<Context>> getAllContexts() {
        return ResponseEntity.ok().body(service.getAllContexts());
    }
}
