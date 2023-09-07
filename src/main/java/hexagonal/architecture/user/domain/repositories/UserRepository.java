package hexagonal.architecture.user.domain.repositories;

import hexagonal.architecture.user.domain.models.User;

import java.util.List;

public interface UserRepository {
    User save(final User model);

    void update(final User model, String updatedPassword);

    List<User> getAllUsers();
}
