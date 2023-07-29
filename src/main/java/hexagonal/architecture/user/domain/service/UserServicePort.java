package hexagonal.architecture.user.domain.service;

import hexagonal.architecture.user.domain.model.User;
import hexagonal.architecture.user.application.input.dto.UserSaveDTO;

import java.util.List;

public interface UserServicePort {


    String getHelloWorld();

    User save(UserSaveDTO model);

    List<User> getAllContexts();
}
