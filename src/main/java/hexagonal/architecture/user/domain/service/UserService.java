package hexagonal.architecture.user.domain.service;

import hexagonal.architecture.user.domain.model.User;
import hexagonal.architecture.user.application.input.dto.UserSaveDTO;
import hexagonal.architecture.user.application.output.persistence.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record UserService(UserRepository repository) implements UserServicePort {
    @Override
    public String getHelloWorld() {
        return "Hello World";
    }

    @Override
    public User save(UserSaveDTO model) {
        var userSaved = this.repository.save(model);
        return userSaved;
    }
    @Override
    public List<User> getAllContexts() {
        return this.repository.getAllUsers();
    }
}
