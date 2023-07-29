package hexagonal.architecture.cqrs.user.application.output.persistence;

import hexagonal.architecture.cqrs.user.application.input.commands.UserSaveCommand;
import hexagonal.architecture.cqrs.user.domain.model.User;

import java.util.Set;

public interface UserRepository {
    User save(UserSaveCommand model);
    Set<User> getAllUsers();
    Boolean emailAlreadyExists(String email);
}
