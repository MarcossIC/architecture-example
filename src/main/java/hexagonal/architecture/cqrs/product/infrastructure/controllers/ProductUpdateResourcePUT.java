package hexagonal.architecture.cqrs.product.infrastructure.controllers;

import hexagonal.architecture.cqrs.product.domain.models.command.ProductUpdateCommand;
import hexagonal.architecture.shared.domain.services.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductUpdateResourcePUT {
    private final CommandBus bus;

    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody ProductUpdateCommand command) {

        bus.dispatch(command);

        return ResponseEntity.noContent().build();
    }
}
