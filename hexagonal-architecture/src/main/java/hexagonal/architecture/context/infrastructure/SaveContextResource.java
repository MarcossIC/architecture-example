package hexagonal.architecture.context.infrastructure;

import hexagonal.architecture.context.domain.ContextServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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
        return ResponseEntity.created(URI.create("http://localhost/api/contexts/"+name)).build();
    }
}
