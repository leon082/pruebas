
package carrito.compras.web.rest;

import carrito.cmpras.core.pojo.facturaProductos;
import carrito.compras.core.service.impl.PedidoService;
import carrito.compras.model.Pedido;
import java.math.BigDecimal;
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
@RequestMapping (value = "/pedido")
public class UIPedido {
    
    @Autowired
    private PedidoService pedidoService;
    
    @RequestMapping (value = "/add",method = RequestMethod.POST)
    public ResponseEntity<Map<String,String>> addCategoria (@RequestBody facturaProductos facctura){
        Map<String,String> value = new HashMap<>();
        try {
            boolean flag = pedidoService.add(facctura);
            if (flag) {
                value.put ("value", "Creado");
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
    
    @RequestMapping (value = "/update",method = RequestMethod.PUT)
    public ResponseEntity<Map<String,String>> update (@RequestBody Pedido pedido){
        Map<String,String> value = new HashMap<>();
        try {
            boolean flag = pedidoService.updateCatgoria(pedido);
            if (flag == true) {
                value.put("value", "Actuallizado");
                return new ResponseEntity<>(value, HttpStatus.OK);
            } else {
                value.put("value", "ErrorActualizar");
                return new ResponseEntity<>(value, HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            value.put("value", "ErrorActualizar");
            return new ResponseEntity<>(value, HttpStatus.CONFLICT);
        }
    }
    
    @RequestMapping (value = "/delet",method = RequestMethod.PUT)
    public ResponseEntity<Map<String,String>> delet (@RequestBody Pedido pedido){
        Map<String,String> value = new HashMap<>();
        try {
            boolean flag = pedidoService.deletCategoria(pedido);
            if (flag == true) {
                value.put("value", "Eliminado");
                return new ResponseEntity<>(value, HttpStatus.OK);
            } else {
                value.put("value", "ErrorEliminar");
                return new ResponseEntity<>(value, HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            value.put("value", "ErrorEliminar");
            return new ResponseEntity<>(value, HttpStatus.CONFLICT);
        }
    }
}
