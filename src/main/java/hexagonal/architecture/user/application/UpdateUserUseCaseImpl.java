package hexagonal.architecture.user.application;

import hexagonal.architecture.user.domain.mappers.UserMapper;
import hexagonal.architecture.user.domain.models.dto.UpdateUserDTO;
import hexagonal.architecture.user.domain.repositories.UserRepository;
import hexagonal.architecture.user.domain.usecase.UpdateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {
    private final UserRepository repository;
    @Qualifier("defaultMapper")
    private final UserMapper mapper;

    @Override
    public void updateUser(UpdateUserDTO dto) {
        var model = mapper.updateDtoToModel.map(dto);

        repository.update(model, dto.oldPassword());
    }

}
