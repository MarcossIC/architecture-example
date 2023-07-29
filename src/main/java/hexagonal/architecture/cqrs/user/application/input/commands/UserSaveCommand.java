package hexagonal.architecture.cqrs.user.application.input.commands;

import hexagonal.architecture.shared.domain.command.Command;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Builder
public class UserSaveCommand implements Command {
    @NotEmpty
    @Length(min = 3, max = 30)
    String username;

    @Email
    @Length(max = 126)
    String email;

    @NotEmpty
    @Length(min = 3, max = 30)
    String password;
}
