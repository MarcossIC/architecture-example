package hexagonal.architecture.cqrs.product.domain.models.command;

import hexagonal.architecture.shared.domain.model.command.Command;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Value
public class ProductUpdateCommand implements Command {
    @NotEmpty
    String id;
    @Length(min = 4, max = 70)
    String name;
    Integer price;
}
