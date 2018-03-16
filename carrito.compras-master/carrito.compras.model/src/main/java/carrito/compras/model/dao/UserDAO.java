
package carrito.compras.model.dao;

import carrico.compras.model.mapper.UserMapper;
import carrito.compras.model.User;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pragma.orm.DataBaseType;
import pragma.orm.SpringPersistenceDAO;


/**
 *
 * @author leonardo.aedo
 */
@Repository
public class UserDAO extends SpringPersistenceDAO<User>{
    
    @Autowired
    public UserDAO (DataSource dataSource){
        super(dataSource, DataBaseType.MYSQL);
    }
    
    public List<User> Login (User user){
        boolean login;
        String sql = "SELECT * FROM USER U WHERE 1=1 ";
        Map<String, Object> productos = new LinkedHashMap<>();
        if (user != null) {
            sql += " AND UPPER (U.username =:user)";
            productos.put("user", user.getUsername());
        }
        if (user != null) {
            sql += " AND UPPER(U.password =:password)";
            productos.put("password", user.getPassword());
        }
        return getNamedParameterJdbcTemplate().query(sql, productos , new UserMapper());
    }
}
