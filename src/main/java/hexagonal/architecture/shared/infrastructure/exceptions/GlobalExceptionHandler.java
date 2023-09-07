package hexagonal.architecture.shared.infrastructure.exceptions;

import hexagonal.architecture.shared.domain.model.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDTO> runtimeExceptionHandler(RuntimeException exception) {
        var response = ExceptionDTO
                .builder()
                .message(exception.getMessage())
                .type(exception.getClass().getTypeName())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();

        return ResponseEntity.badRequest().body(response);
    }
}
