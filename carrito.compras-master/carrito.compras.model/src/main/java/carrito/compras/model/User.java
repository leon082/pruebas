
package carrito.compras.model;

import java.util.Date;
import pragma.orm.annotation.Attribute;
import pragma.orm.annotation.Entity;

/**
 *
 * @author leonardo.aedo
 */
@Entity (name = "USER")
public class User {
    @Attribute (name = "username", key = true)
    private String username;
    
    @Attribute (name = "email")
    private String email;
    
    @Attribute (name = "password")
    private String password;
    
    @Attribute (name = "create_time")
    private Date createTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
