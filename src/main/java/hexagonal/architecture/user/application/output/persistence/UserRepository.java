package hexagonal.architecture.user.application.output.persistence;

import hexagonal.architecture.user.domain.model.User;
import hexagonal.architecture.user.application.input.dto.UserSaveDTO;

import java.util.List;

public interface UserRepository {
    User save(UserSaveDTO model);
    List<User> getAllUsers();
    Boolean emailAlreadyExists(String email);
}
