
package carrito.compras.core.service;

import carrito.compras.model.CategoriaProducto;
import carrito.compras.model.DetallePedido;
import java.util.List;

/**
 *
 * @author leonardo.aedo
 */
public interface IDetallePedido {
    
    public boolean addDetallePedido (DetallePedido detallePedido) throws Exception;
    
    public boolean updateDetallePedido (DetallePedido detallePedido) throws Exception;
    
    public boolean deletDetallePedido (DetallePedido detallePedido) throws Exception;
    
    public List<DetallePedido> pedidosCodProducto (String codProducto)throws Exception;
    
}
