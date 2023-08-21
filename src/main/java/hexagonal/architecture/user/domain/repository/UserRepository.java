package hexagonal.architecture.user.domain.repository;

import hexagonal.architecture.user.domain.model.User;
import hexagonal.architecture.user.domain.model.dto.UserSaveDTO;

import java.util.List;

public interface UserRepository {
    User save(final UserSaveDTO model);
    List<User> getAllUsers();
    Boolean emailAlreadyExists(final String email);
}
