
package carrito.compras.core.service;

import carrito.cmpras.core.pojo.CategoriaPorProducto;
import carrito.cmpras.core.pojo.FiltroBusqueda;
import carrito.compras.model.Producto;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author leonardo.aedo
 */

public interface IProductoService {
    
    public boolean add (Producto producto) throws Exception;
     
    public boolean edit (Producto producto) throws Exception;

    public boolean deletproducto (Producto producto) throws Exception;
     
    public List<Producto> productos ()throws Exception;
    
    public Producto selectByKey(BigDecimal codProducto) throws Exception;
    
    public List<Producto> searchByParams(Producto producto) throws Exception;
    
    public List<Producto> FiltroUusario (FiltroBusqueda filtro) throws Exception;

}
