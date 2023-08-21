package hexagonal.architecture.user.domain.usecase;

import hexagonal.architecture.user.domain.model.User;

import java.util.List;

public interface ListAllUserUseCase {
    List<User> getAllContexts();
}
