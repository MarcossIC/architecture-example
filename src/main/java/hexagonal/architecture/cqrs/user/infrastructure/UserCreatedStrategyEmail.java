package hexagonal.architecture.cqrs.user.infrastructure;

import hexagonal.architecture.shared.domain.util.EmailTemplateStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreatedStrategyEmail implements EmailTemplateStrategy {
    @Override
    public String buildTemplate() {
        return """
                <!DOCTYPE html>
                <html>
                <head>
                    <meta charset="UTF-8">
                    <style>
                        .container {
                                max-width: 500px;
                                margin: 0 auto;
                                padding: 20px;
                                background-color: #ffffff;
                                border: 1px solid #ddd;
                                border-radius: 4px;
                                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                                color: #222227;
                        }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <h1>%s espero se encuentre bien</h1>
                        </hr>
                        <p>Se ha creado su cuenta en nuestro sitio!</p>
                    </div>
                </body>
                </html>  
                """;
    }

    @Override
    public String replaceParameters(Object... values) {
        return String.format(buildTemplate(), values);
    }
}
