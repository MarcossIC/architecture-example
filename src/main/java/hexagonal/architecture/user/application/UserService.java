package hexagonal.architecture.user.application;

import hexagonal.architecture.user.domain.UserModel;
import hexagonal.architecture.user.domain.UserSaveModel;
import hexagonal.architecture.user.domain.ports.UserRepository;
import hexagonal.architecture.user.domain.ports.UserServicePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record UserService(UserRepository repository) implements UserServicePort {
    @Override
    public String getHelloWorld() {
        return "Hello World";
    }

    @Override
    public UserModel save(UserSaveModel model) {
        var userSaved = this.repository.save(model);

        return userSaved;
    }
    @Override
    public List<UserModel> getAllContexts() {
        return this.repository.getAllUsers();
    }
}
