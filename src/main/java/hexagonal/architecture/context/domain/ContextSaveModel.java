package hexagonal.architecture.context.domain;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotEmpty;

@Builder
@Value
public class ContextSaveModel {

    @NotEmpty
    String id;

    @NotEmpty
    String name;
}
