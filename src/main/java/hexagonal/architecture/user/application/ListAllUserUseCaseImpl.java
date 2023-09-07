package hexagonal.architecture.user.application;

import hexagonal.architecture.user.domain.models.User;
import hexagonal.architecture.user.domain.repositories.UserRepository;
import hexagonal.architecture.user.domain.usecase.ListAllUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListAllUserUseCaseImpl implements ListAllUserUseCase {
    private final UserRepository repository;

    @Override
    public List<User> getAllContexts() {
        return this.repository.getAllUsers();
    }
}
