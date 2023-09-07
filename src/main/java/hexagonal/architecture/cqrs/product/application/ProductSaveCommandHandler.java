package hexagonal.architecture.cqrs.product.application;

import hexagonal.architecture.cqrs.product.domain.mappers.ProductMapper;
import hexagonal.architecture.cqrs.product.domain.models.command.ProductSaveCommand;
import hexagonal.architecture.cqrs.product.domain.repositories.ProductRepository;
import hexagonal.architecture.shared.domain.services.command.CommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductSaveCommandHandler implements CommandHandler<ProductSaveCommand> {
    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public void handle(ProductSaveCommand command) {
        var model = mapper.saveCommandToModel.map(command);

        this.repository.save(model);
    }
}
