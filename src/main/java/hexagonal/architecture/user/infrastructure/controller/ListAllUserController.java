package hexagonal.architecture.user.infrastructure.controller;

import hexagonal.architecture.user.domain.models.User;
import hexagonal.architecture.user.domain.usecase.ListAllUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class ListAllUserController {
    private final ListAllUserUseCase useCase;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<List<User>> saveUser() {
        var user = useCase.getAllContexts();

        return ResponseEntity.ok(user);
    }
}
