package hexagonal.architecture.cqrs.user.application.input;

import hexagonal.architecture.cqrs.user.application.input.query.UserAllQuery;
import hexagonal.architecture.cqrs.user.domain.model.User;
import hexagonal.architecture.cqrs.user.domain.model.UserList;
import hexagonal.architecture.shared.domain.query.QueryBus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class UserAllResourceGET {
    private final QueryBus queryBus;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Set<User>> saveUser() {
        var response = (UserList) this.queryBus.ask(UserAllQuery.builder().build());
        return ResponseEntity.ok(response.getUsers());
    }
}
