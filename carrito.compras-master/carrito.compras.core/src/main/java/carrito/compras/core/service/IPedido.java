
package carrito.compras.core.service;

import carrito.cmpras.core.pojo.facturaProductos;
import carrito.compras.model.Pedido;
import java.math.BigDecimal;

/**
 *
 * @author leonardo.aedo
 */
public interface IPedido {
    
    public boolean add (facturaProductos facctura) throws Exception;
    
    public boolean updateCatgoria (Pedido pedido) throws Exception;
    
    public boolean deletCategoria (Pedido Pedido) throws Exception;
        
    
}
