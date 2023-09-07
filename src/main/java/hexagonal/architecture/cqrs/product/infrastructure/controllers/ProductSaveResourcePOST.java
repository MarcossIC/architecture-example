package hexagonal.architecture.cqrs.product.infrastructure.controllers;

import hexagonal.architecture.cqrs.product.domain.models.command.ProductSaveCommand;
import hexagonal.architecture.shared.domain.services.command.CommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public final class ProductSaveResourcePOST {
    private final CommandHandler<ProductSaveCommand> saveHandler;

    @PostMapping
    public HttpEntity<Void> saveUser(@RequestBody @Valid ProductSaveCommand command) {
        saveHandler.handle(command);

        return ResponseEntity.created(URI.create("/api/users/")).build();
    }
}