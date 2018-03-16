
package carrito.compras.web.rest;

import carrito.compras.core.service.impl.UserService;
import carrito.compras.model.User;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author leonardo.aedo
 */
@RestController
@RequestMapping (value = "/user")
public class UIUserRest {
    
    @Autowired
    private UserService userService;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UIUserRest.class);
    
    @RequestMapping (value = "/verificar",method = RequestMethod.POST)
    public ResponseEntity<List<User>> verificar (@RequestBody User user){
            List<User> usuario = userService.verificar(user);
            if (usuario != null) {
                return new ResponseEntity<>(usuario, HttpStatus.OK);
            } else {
                return null;
            }
    }
}
