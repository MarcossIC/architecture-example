package hexagonal.architecture.cqrs.product.domain.models.command;

import hexagonal.architecture.shared.domain.model.command.Command;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@EqualsAndHashCode
public class ProductSaveCommand implements Command {
    @Length(min = 4, max = 70)
            @NotEmpty
    String name;

    @NotNull
    Integer price;
}
