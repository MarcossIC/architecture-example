package hexagonal.architecture.shared.domain.util;

/**
 * Interfaz que para aplicar el patron Strategy a los template
 */
public interface EmailTemplateStrategy {

    String buildTemplate();

    String replaceParameters(Object... values);
}
