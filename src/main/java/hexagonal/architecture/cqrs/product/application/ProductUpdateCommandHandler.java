package hexagonal.architecture.cqrs.product.application;

import hexagonal.architecture.cqrs.product.domain.mappers.ProductMapper;
import hexagonal.architecture.cqrs.product.domain.models.command.ProductUpdateCommand;
import hexagonal.architecture.cqrs.product.domain.repositories.ProductRepository;
import hexagonal.architecture.shared.domain.services.command.CommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductUpdateCommandHandler implements CommandHandler<ProductUpdateCommand> {
    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public void handle(ProductUpdateCommand command) {
        var model = mapper.updateDtoToModel.map(command);

        repository.update(model);
    }

}
