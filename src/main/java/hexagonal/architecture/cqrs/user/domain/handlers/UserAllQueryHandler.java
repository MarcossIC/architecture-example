package hexagonal.architecture.cqrs.user.domain.handlers;

import hexagonal.architecture.cqrs.user.application.input.query.UserAllQuery;
import hexagonal.architecture.cqrs.user.application.output.persistence.UserRepository;
import hexagonal.architecture.cqrs.user.domain.model.UserList;
import hexagonal.architecture.shared.domain.services.query.QueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAllQueryHandler implements QueryHandler<UserAllQuery, UserList> {
    private final UserRepository repository;
    @Override
    public UserList handle(UserAllQuery query) throws Exception {
        return UserList.builder()
                .users( this.repository.getAllUsers() )
                .build();
    }
}
