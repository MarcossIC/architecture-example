package hexagonal.architecture.user.domain.ports;

import hexagonal.architecture.user.domain.UserModel;
import hexagonal.architecture.user.domain.UserSaveModel;

import java.util.List;

public interface UserServicePort {


    String getHelloWorld();

    UserModel save(UserSaveModel model);

    List<UserModel> getAllContexts();
}
