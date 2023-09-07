package hexagonal.architecture.cqrs.product.infrastructure.controllers;

import hexagonal.architecture.cqrs.product.domain.models.Product;
import hexagonal.architecture.cqrs.product.domain.models.dto.ProductList;
import hexagonal.architecture.cqrs.product.domain.models.query.ProductAllQuery;
import hexagonal.architecture.shared.domain.services.query.QueryBus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductAllResourceGET {
    private final QueryBus queryBus;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Set<Product>> saveUser() {

        var response = (ProductList) this.queryBus.ask(ProductAllQuery.builder().build());

        return ResponseEntity.ok(response.getProducts());
    }
}
