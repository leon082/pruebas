
package carrito.compras.web.rest;

import carrito.compras.core.service.ICategoriaService;
import carrito.compras.model.Categoria;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author leonardo.aedo
 */
@RestController
@RequestMapping (value = "/categoria")
public class UICategoriaRest {
    
    @Autowired
    private ICategoriaService categoriaService;
    
    
    @RequestMapping (value = "/add/",method = RequestMethod.POST)
    public ResponseEntity<Map<String,String>> addCategoria (@RequestBody Categoria categoria){
        Map<String,String> value = new HashMap<>();
        try {
            boolean flag = categoriaService.addCategoria(categoria);
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
    
    @RequestMapping (value = "/update",method = RequestMethod.PUT)
    public ResponseEntity<Map<String,String>> update (@RequestBody Categoria categoria){
        Map<String,String> value = new HashMap<>();
        try {
            boolean flag = categoriaService.updateCatgoria(categoria);
            if (flag == true) {
                value.put("value", "Actuallizado");
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
    
    @RequestMapping (value = "/delet",method = RequestMethod.POST)
    public ResponseEntity<Map<String,String>> delet (@RequestBody Categoria categoria){
        Map<String,String> value = new HashMap<>();
        try {
            boolean flag = categoriaService.deletCategoria(categoria);
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
    
    @RequestMapping (value = "/listCategoria",method = RequestMethod.GET)
    public ResponseEntity<List<Categoria>> listaCategoria (){
        try {
            List<Categoria> categorias = categoriaService.categorias();
            if (categorias != null) {
                return new ResponseEntity<>(categorias, HttpStatus.OK);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    @RequestMapping (value = "/searchById/{codCategoria}",method = RequestMethod.POST)
    public Categoria searchById (@PathVariable("codCategoria") BigDecimal codCategoria){
        try {
            Categoria categoriaById = categoriaService.categoriasById(codCategoria);
            if (categoriaById != null) {
                return categoriaById;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
     @RequestMapping (value = "/searchByParams/",method = RequestMethod.POST)
    public ResponseEntity<List<Categoria>> searchByParams (@RequestBody Categoria categoria){
        try {
            List<Categoria> categorias = categoriaService.searchByParams(categoria);
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
