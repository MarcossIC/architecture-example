package hexagonal.architecture.user.domain.models.dto;

import lombok.Builder;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Builder
public record SaveUserDTO(
        @NotEmpty
        @Length(min = 3, max = 30)
        String username,
        @NotEmpty
        @Email
        @Length(max = 126)
        String email,
        @NotEmpty
        @Length(min = 3, max = 30)
        String password
) {
}
