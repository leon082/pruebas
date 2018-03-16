
package carrito.compras.core.service.impl;

import carrito.compras.core.service.IUserService;
import carrito.compras.model.User;
import carrito.compras.model.dao.UserDAO;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author leonardo.aedo
 */
@Service
public class UserService implements IUserService {
    
    @Autowired
    private UserDAO userDAO;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    
    /**
     * 
     * @param user
     * @return
     * @throws Exception 
     */
    @Override
    public List<User> verificar (User user){
        try {
            List<User> us = userDAO.Login(user);
            return us;
        } catch (RuntimeException e) {
        e.printStackTrace();
//            LOGGER.error(e.getMessage(),e);
            return null;
        }
    }
}
