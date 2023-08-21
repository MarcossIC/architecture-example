package hexagonal.architecture.user.application.usecase;

import hexagonal.architecture.user.domain.model.User;
import hexagonal.architecture.user.domain.model.dto.UserSaveDTO;
import hexagonal.architecture.user.domain.usecase.SaveUserUseCase;
import hexagonal.architecture.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Este es un ejemplo simple
 * Pero la logica deberia de estar principalmente aqui
 */
@Component
@RequiredArgsConstructor
public class SaveUserUseCaseImpl implements SaveUserUseCase {
    private final UserRepository repository;

    @Override
    public User save(UserSaveDTO model) {
        return this.repository.save(model);
    }
}
