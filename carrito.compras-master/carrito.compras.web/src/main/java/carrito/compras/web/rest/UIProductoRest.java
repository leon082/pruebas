
package carrito.compras.web.rest;

import carrito.cmpras.core.pojo.CategoriaPorProducto;
import carrito.cmpras.core.pojo.FiltroBusqueda;
import carrito.compras.core.service.impl.ProductoService;
import carrito.compras.model.Producto;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping (value = "/producto")
public class UIProductoRest {
    
    @Autowired
    private ProductoService productoService;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UIProductoRest.class);
    
    @RequestMapping (value = "/add",method = RequestMethod.POST)
    public ResponseEntity<Map<String,String>> addProducto (@RequestBody Producto producto){
        Map<String,String> value = new HashMap<>();
        try {
            boolean flag = productoService.add(producto);
            if (flag == true) {
                value.put("value", "Creado");
                return new ResponseEntity<>(value, HttpStatus.OK);
            } else {
                value.put("value", "Error");
                return new ResponseEntity<>(value, HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            value.put("value", "Error");
            return new ResponseEntity<>(value, HttpStatus.CONFLICT);
        }
    }
    
    @RequestMapping (value = "/update",method = RequestMethod.PUT)
    public ResponseEntity<Map<String,String>> update (@RequestBody Producto producto){
        Map<String,String> value = new HashMap<>();
        try {
            boolean flag = productoService.edit(producto);
            if (flag == true) {
                value.put("value", "Actuallizado");
                return new ResponseEntity<>(value, HttpStatus.OK);
            } else {
                value.put("value", "Error");
                return new ResponseEntity<>(value, HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(value, HttpStatus.CONFLICT);
        }
    }
    
    @RequestMapping (value = "/delet",method = RequestMethod.DELETE)
    public ResponseEntity<Map<String,String>> delet (@RequestBody Producto producto){
        Map<String,String> value = new HashMap<>();
        try {
            boolean flag = productoService.deletproducto(producto);
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
    
    @RequestMapping (value = "/listProductos",method = RequestMethod.GET)
    public ResponseEntity<List<Producto>> listaProductos (){
        try {
            List<Producto> prouctos = productoService.productos();
            if (prouctos != null) {
                return new ResponseEntity<>(prouctos, HttpStatus.OK);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    
    @RequestMapping (value = "/productoByKey/{codProductoRow}",method = RequestMethod.POST)
    public Producto productoByKey (@PathVariable("codProductoRow") BigDecimal codProductoRow){
        try {
            Producto prouctos = productoService.selectByKey(codProductoRow);
            if (prouctos != null) {
                return prouctos;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    @RequestMapping (value = "/searchByParams",method = RequestMethod.POST)
    public List<Producto> searchByParams (@RequestBody Producto producto){
            try {
                List<Producto> productos = productoService.searchByParams(producto);
                return productos;
            } catch (Exception e) {
                return null;
            }
    }
    
    @RequestMapping (value = "/filtroUsuario",method = RequestMethod.POST)
    public List<Producto> searchById (@RequestBody FiltroBusqueda filtro){
        try {
            List<Producto> productoFiltro = productoService.FiltroUusario(filtro);
            return productoFiltro;
        } catch (Exception e) {
            return null;
        }
    }
    
}
