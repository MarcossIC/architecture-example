package hexagonal.architecture.cqrs.user.domain.model;

import hexagonal.architecture.shared.domain.query.Response;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
public class UserList implements Response {
    private Set<User> users;


    public Set<User> getUsers(){
        return users;
    }
}
