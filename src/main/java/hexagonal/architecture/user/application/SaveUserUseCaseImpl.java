package hexagonal.architecture.user.application;

import hexagonal.architecture.user.domain.mappers.UserMapper;
import hexagonal.architecture.user.domain.models.User;
import hexagonal.architecture.user.domain.models.dto.SaveUserDTO;
import hexagonal.architecture.user.domain.repositories.UserRepository;
import hexagonal.architecture.user.domain.usecase.SaveUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SaveUserUseCaseImpl implements SaveUserUseCase {
    private final UserRepository repository;
    @Qualifier("defaultMapper")
    private final UserMapper userMapper;

    @Override
    public User save(SaveUserDTO dto) {
        var model = this.userMapper.saveDtoToModel.map(dto);
        return this.repository.save(model);
    }
}
