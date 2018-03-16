
package carrito.compras.web.rest;

import carrito.cmpras.core.pojo.CategoriaPorProducto;
import carrito.compras.core.service.ICategoriaProducto;
import carrito.compras.model.CategoriaProducto;
import java.util.HashMap;
import java.util.List;
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
@RequestMapping (value = "/categoriaProducto")
public class UICategoriaProducto {
    
    @Autowired
    private ICategoriaProducto categoriaProductoService;
    
    @RequestMapping (value = "/add",method = RequestMethod.POST)
    public ResponseEntity<Map<String,String>> add (@RequestBody CategoriaPorProducto categoriaXProducto){
        Map<String,String> value = new HashMap<>();
        try {
            boolean flag = categoriaProductoService.addCategoriaProducto(categoriaXProducto);
            if (flag == true) {
                value.put("value", "Creado");
                return new ResponseEntity<>(value, HttpStatus.OK);
            } else {
                value.put("value", "Error");
                return new ResponseEntity<>(value, HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            value.put("value", "ErrorCreado");
            return new ResponseEntity<>(value, HttpStatus.CONFLICT);
        }
    }
    
    @RequestMapping (value = "/delet",method = RequestMethod.PUT)
    public ResponseEntity<Map<String,String>> delet (@RequestBody CategoriaProducto categoriaProducto){
        Map<String,String> value = new HashMap<>();
        try {
            boolean flag = categoriaProductoService.deletCategoriaProducto(categoriaProducto);
            if (flag == true) {
                value.put("value", "Eliminado");
                return new ResponseEntity<>(value, HttpStatus.OK);
            } else {
                value.put("value", "Error");
                return new ResponseEntity<>(value, HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            value.put("value", "ErrorElminar");
            return new ResponseEntity<>(value, HttpStatus.CONFLICT);
        }
    }
    
    @RequestMapping (value = "/listCategorias",method = RequestMethod.POST)
    public ResponseEntity<List<CategoriaProducto>> listaCategoria (String codProducto){
        try {
            List<CategoriaProducto> categorias = categoriaProductoService.selectByCodProucto(codProducto);
            if (categorias != null) {
                return new ResponseEntity<>(categorias, HttpStatus.OK);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    } 
    
}
