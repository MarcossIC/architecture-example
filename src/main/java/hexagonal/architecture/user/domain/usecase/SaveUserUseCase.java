package hexagonal.architecture.user.domain.usecase;

import hexagonal.architecture.user.domain.model.User;
import hexagonal.architecture.user.domain.model.dto.UserSaveDTO;

public interface SaveUserUseCase {
    User save(final UserSaveDTO model);
}
