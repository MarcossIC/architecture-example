package hexagonal.architecture.user.domain.usecase;

import hexagonal.architecture.user.domain.models.dto.UpdateUserDTO;

public interface UpdateUserUseCase {

    void updateUser(final UpdateUserDTO dto);
}
