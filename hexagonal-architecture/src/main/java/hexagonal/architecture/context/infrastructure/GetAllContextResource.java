package hexagonal.architecture.context.infrastructure;

import hexagonal.architecture.context.domain.Context;
import hexagonal.architecture.context.domain.ContextServicePort;
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
public class GetAllContextResource {
    public ContextServicePort service;

    @Autowired
    public GetAllContextResource(ContextServicePort service) {
        this.service = service;
    }

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<List<Context>> getHello(){
        return ResponseEntity.ok().body(service.getAll());
    }
}
