package hexagonal.architecture.global.infrastructure;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import hexagonal.architecture.global.domain.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityMySQLRepository implements EntityRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public <T> T save(T entity) {
        //Con reflext recupera un array de los atributos de la clase declarados
        Field[] entityFields = entity.getClass().getDeclaredFields();

        List<String> fields = new ArrayList<>();
        List<Object> fieldValue = new ArrayList<>();

        Arrays.stream(entityFields).forEach(field->{
            //Hago una lista con los nombres de los atributos
            fields.add(field.getName());
            try {
                //Lista con los valores de los atributos
                fieldValue.add(entity
                        .getClass()
                        //Recupera el metodo "get" de la entidad, segun el atributo que se encuentra actualmente
                        .getMethod("get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1) )
                        //Invoca al metodo recuperado, de la entidad que fue pasada
                        .invoke(entity));
            } catch (IllegalAccessException
                     | IllegalArgumentException | InvocationTargetException
                     | NoSuchMethodException    | SecurityException e) {
                e.printStackTrace();
            }
        });

        var sql = new StringBuilder();

        sql.append("INSERT INTO ")
                .append( entity.getClass().getSimpleName() )
                .append( "(" ).append( String.join( ",", fields) ).append( ")" )
                .append( " VALUES " )
                .append( "(" ).append( String.join( ",", Collections.nCopies( fields.size(), "?") ) ).append( ")" );

        jdbcTemplate.update(sql.toString(), fieldValue);
        return entity;
    }

    @Override
    public <T> T getById(String id, Class<T> clazz) {
        List<T> list = jdbcTemplate.query("SELECT * FROM "+clazz.getSimpleName()+" WHERE id = ?",
                new LombokRowMapper<T>(clazz),
                id );

        if ( !list.isEmpty() ) return list.get(0);
        return null;
    }

    @Override
    public <T> List<T> getAll(Class<T> clazz) {
        return jdbcTemplate.query("SELECT * FROM "+clazz.getSimpleName(), new LombokRowMapper<T>(clazz));
    }

    private class LombokRowMapper<T> implements RowMapper<T> {
        private Class<?> clazz = null;

        public LombokRowMapper( Class<?> clazz ) {
            this.clazz = clazz;
        }
        @Override
        public T mapRow(ResultSet rs, int rowNum) throws SQLException {

            try {
                Method builderMethod = clazz.getMethod("builder");
                if ( builderMethod == null ) return null;

                Object row = builderMethod.invoke(null);
                Method[] m = row.getClass().getDeclaredMethods();

                for ( int i=0; i<m.length; i++ ) {
                    int pos = -1;

                    try { pos = rs.findColumn(  m[i].getName()  ); } catch ( SQLException ex ) {  }

                    if ( pos != -1 ) {
                        Object fieldValue = rs.getObject( pos );

                        m[i].invoke( row, fieldValue );
                    }
                }

                return (T) row.getClass().getMethod("build").invoke(row);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                     | NoSuchMethodException | SecurityException e) {
                e.printStackTrace();
            }

            return null;
        }

    }
}
