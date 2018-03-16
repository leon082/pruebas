
package carrito.compras.web.rest;

import carrito.compras.core.service.impl.DetallePedidoService;
import carrito.compras.model.DetallePedido;
import java.util.HashMap;
import java.util.Map;
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
@RequestMapping (value = "/detallePedido")
public class DetallePedidoRest {
    
    @Autowired
    private DetallePedidoService detallePeidoService;
    
    @RequestMapping (value = "/add",method = RequestMethod.POST)
    public ResponseEntity<Map<String,String>> addCategoria (@RequestBody DetallePedido detallePedido){
        Map<String,String> value = new HashMap<>();
        try {
            boolean flag = detallePeidoService.addDetallePedido(detallePedido);
            if (flag == true) {
                value.put("value", "Creado");
                return new ResponseEntity<>(value, HttpStatus.OK);
            } else {
                value.put("value", "Error");
                return new ResponseEntity<>(value, HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            value.put("value", "ErrorCatch");
            return new ResponseEntity<>(value, HttpStatus.CONFLICT);
        }
    }
    
    @RequestMapping (value = "/delet",method = RequestMethod.PUT)
    public ResponseEntity<Map<String,String>> delet (@RequestBody DetallePedido detallePedido){
        Map<String,String> value = new HashMap<>();
        try {
            boolean flag = detallePeidoService.deletDetallePedido(detallePedido);
            if (flag == true) {
                value.put("value", "Eliminado");
                return new ResponseEntity<>(value, HttpStatus.OK);
            } else {
                value.put("value", "Error");
                return new ResponseEntity<>(value, HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            value.put("value", "ErrorCatch");
            return new ResponseEntity<>(value, HttpStatus.CONFLICT);
        }
    }
}
