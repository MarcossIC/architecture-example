package com.architecture.ddd.context.infrastructure;

import com.architecture.ddd.context.domain.ContextServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/contexts")
public class SaveContextResource {
    public ContextServicePort service;

    @Autowired
    public SaveContextResource(ContextServicePort service) {
        this.service = service;
    }

    @PostMapping("/{name}")
    public HttpEntity<Void> saveContext(@PathVariable String name){
        service.save(name);
        return created(URI.create("http://localhost/api/contexts/"+name)).build();
    }
}
