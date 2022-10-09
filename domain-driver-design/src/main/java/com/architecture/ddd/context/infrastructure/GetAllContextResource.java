package com.architecture.ddd.context.infrastructure;

import com.architecture.ddd.context.domain.Context;
import com.architecture.ddd.context.domain.ContextServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/contexts")
public class GetAllContextResource {
    public ContextServicePort service;

    @Autowired
    public GetAllContextResource(ContextServicePort service) {
        this.service = service;
    }

    @GetMapping()
    public HttpEntity<List<Context>> getHello(){
        var response = service.getAll();
        return ok().body(response);
    }
}
