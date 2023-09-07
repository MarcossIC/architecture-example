package hexagonal.architecture.user.domain.usecase;

import hexagonal.architecture.user.domain.models.User;

import java.util.List;

public interface ListAllUserUseCase {
    List<User> getAllContexts();
}
