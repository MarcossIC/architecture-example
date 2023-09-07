package hexagonal.architecture.cqrs.product.domain.mappers;

import hexagonal.architecture.cqrs.product.domain.models.Product;
import hexagonal.architecture.cqrs.product.domain.models.command.ProductSaveCommand;
import hexagonal.architecture.cqrs.product.domain.models.command.ProductUpdateCommand;
import hexagonal.architecture.shared.domain.mapper.AbstractMapper;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.OptionalInt;

@Component(value = "cqrsMapper")
@NoArgsConstructor
public class ProductMapper {

    public final AbstractMapper<ProductSaveCommand, Product> saveCommandToModel = (dto) ->
            Product.builder()
                    .id("")
                    .name(Optional.of( dto.getName() ).orElse(""))
                    .price(Optional.of( dto.getPrice() ).orElse(0))
                    .build();

    public final AbstractMapper<ProductUpdateCommand, Product> updateDtoToModel = (dto) ->
            Product.builder()
                    .id(dto.getId())
                    .name(Optional.of( dto.getName() ).orElse(""))
                    .price(OptionalInt.of( dto.getPrice() ).orElse( 0 ))
                    .build();
}
