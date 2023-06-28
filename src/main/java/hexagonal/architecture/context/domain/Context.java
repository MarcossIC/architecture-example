package hexagonal.architecture.context.domain;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Builder
@Data
public final class Context {
    @NotEmpty
    private String id;

    @NotEmpty
    private String name;
}
