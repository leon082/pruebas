
package carrico.compras.model.mapper;

import carrito.compras.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author leonardo.aedo
 */
public class UserMapper implements RowMapper<User>{
    
    public UserMapper() {
        super();
    }
    
    @Override
    public User mapRow(ResultSet rs, int rowNuw) throws SQLException {
        User Us = new User();
        
        Us.setUsername(rs.getString("username"));
        Us.setEmail(rs.getString("email"));
        Us.setPassword(rs.getString("password"));
        Us.setCreateTime(rs.getDate("create_time"));
        
        return Us;
    }

}
