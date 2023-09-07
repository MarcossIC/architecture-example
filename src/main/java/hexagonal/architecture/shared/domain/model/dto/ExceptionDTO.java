package hexagonal.architecture.shared.domain.model.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ExceptionDTO {
    String message;
    String type;
    Integer status;
}
