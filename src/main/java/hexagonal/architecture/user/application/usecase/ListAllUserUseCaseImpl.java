package hexagonal.architecture.user.application.usecase;

import hexagonal.architecture.user.domain.model.User;
import hexagonal.architecture.user.domain.usecase.ListAllUserUseCase;
import hexagonal.architecture.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListAllUserUseCaseImpl implements ListAllUserUseCase {
    private final UserRepository repository;
    @Override
    public List<User> getAllContexts() {
        return this.repository.getAllUsers();
    }
}
