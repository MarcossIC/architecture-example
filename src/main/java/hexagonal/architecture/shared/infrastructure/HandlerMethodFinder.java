package hexagonal.architecture.shared.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public class HandlerMethodFinder<T, V> {

    private Stream<Method> methods;

    /**
     * Recupera el nombre de la clase del primer parámetro del primer método.
     *
     * @return El nombre de la clase del primer parámetro o una cadena vacía si no se encuentra.
     */
    public String getFirstParamClassName() {
        return this.methods
                .findFirst()
                .map(method -> method.getParameterTypes()[0].getCanonicalName())
                .orElse("");
    }

    /**
     * Filtra los métodos que no tengan el término especificado en el nombre del primer parámetro.
     *
     * @param term Término a buscar en los nombres de parámetros.
     * @return Un nuevo objeto HandlerMethodFinder con los métodos filtrados.
     */
    public HandlerMethodFinder<T, V> filterByParamTerm(String term) {
        this.methods = this.methods.filter(method -> !method.getParameterTypes()[0].getSimpleName().startsWith(term));
        return this;
    }

    /**
     * Filtra los métodos que tengan "handle" en su nombre.
     *
     * @return Un nuevo objeto HandlerMethodFinder con los métodos filtrados.
     */
    public HandlerMethodFinder<T, V> filterByHandleMethods() {
        this.methods = this.methods.filter(method -> method.getName().equalsIgnoreCase("handle"));
        return this;
    }

    /**
     * Busca todos los métodos de un handler y los devuelve en un objeto HandlerMethodFinder.
     *
     * @param handler Handler para listar métodos.
     * @return Un nuevo objeto HandlerMethodFinder con los métodos del handler.
     */
    public static <T, V> HandlerMethodFinder<T, V> searchMethods(T handler) {
        return new HandlerMethodFinder<>( Arrays.stream(handler.getClass().getMethods()).toList().stream() );
    }

    /**
     * Busca la clase por su nombre proporcionado.
     *
     * @param name Nombre de la clase.
     * @return Un Optional que contiene la clase correspondiente si se encuentra, o un Optional vacío si no.
     */
    public Optional<Class<V>> findClass(String name) {
        try {
            return Optional.of((Class<V>) Class.forName(name));
        } catch (ClassNotFoundException ex) {
            return Optional.empty();
        }
    }
}
