package hexagonal.architecture.user.domain.mappers;

import hexagonal.architecture.shared.domain.mapper.AbstractMapper;
import hexagonal.architecture.user.domain.models.User;
import hexagonal.architecture.user.domain.models.dto.SaveUserDTO;
import hexagonal.architecture.user.domain.models.dto.UpdateUserDTO;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value = "defaultMapper")
@NoArgsConstructor
public class UserMapper {

    public final AbstractMapper<SaveUserDTO, User> saveDtoToModel = (dto) ->
            User.builder()
                    .id("")
                    .email(dto.email())
                    .username(dto.username())
                    .password(dto.password())
                    .build();

    public final AbstractMapper<UpdateUserDTO, User> updateDtoToModel = (dto) ->
            User.builder()
                    .id(dto.id())
                    .email(dto.email() != null ? dto.email() : null)
                    .username(dto.username() != null ? dto.username() : null)
                    .password(dto.password() != null ? dto.password() : null)
                    .build();
}
