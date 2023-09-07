package hexagonal.architecture.user.infrastructure.controller;

import hexagonal.architecture.user.domain.models.dto.UpdateUserDTO;
import hexagonal.architecture.user.domain.usecase.UpdateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UpdateUserController {
    private final UpdateUserUseCase useCase;

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Void> updateUser(@Valid @RequestBody UpdateUserDTO dto) {

        useCase.updateUser(dto);

        return ResponseEntity.noContent().build();
    }
}
