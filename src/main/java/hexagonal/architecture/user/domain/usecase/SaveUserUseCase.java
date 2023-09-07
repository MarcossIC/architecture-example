package hexagonal.architecture.user.domain.usecase;

import hexagonal.architecture.user.domain.models.User;
import hexagonal.architecture.user.domain.models.dto.SaveUserDTO;

public interface SaveUserUseCase {
    User save(final SaveUserDTO model);
}
