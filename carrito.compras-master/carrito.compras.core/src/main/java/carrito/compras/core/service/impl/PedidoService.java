
package carrito.compras.core.service.impl;

import carrito.cmpras.core.pojo.facturaProductos;
import carrito.compras.core.service.IPedido;
import carrito.compras.model.Pedido;
import carrito.compras.model.dao.PedidoDAO;
import carrito.compras.model.DetallePedido;
import carrito.compras.model.Producto;
import carrito.compras.model.dao.DetallePedidoDAO;
import carrito.compras.model.dao.ProductoDAO;
import java.math.BigDecimal;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author leonardo.aedo
 */
@Service
public class PedidoService implements IPedido{
     
    @Autowired
    private PedidoDAO pedidoDAO;
    
    @Autowired 
    private DetallePedidoDAO detallePedido;
    
    @Autowired
    private ProductoDAO productoDAO;
    
    @Autowired
    private GenerarPDF generarPDF;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PedidoService.class);
    
    /**
     * 
     * @param pedido
     * @return true o false
     * @throws Exception 
     */
    
    @Override
    public boolean add (facturaProductos factura) throws Exception{
        Date fecha = new Date();
        factura.getPedido().setFecha(fecha);
        boolean detalles = false;
        String cantidadproducto;
        try {
            BigDecimal cod = pedidoDAO.add(factura.getPedido());
            DetallePedido detalle [] = factura.getDetallePedido();
            for (int i = 0; i < detalle.length ; i++) {
                cantidadproducto = detalle[i].getCantidad();
                detalle[i].setCantidad(detalle[i].getCantidadCompra());
                detalle[i].setCodPedido(cod);
                detalles = detallePedido.persist(detalle[i]);
                
                int total = Integer.parseInt(cantidadproducto) - Integer.parseInt(detalle[i].getCantidad());
                BigDecimal totaFinal = new BigDecimal(total);
                Producto producto = new Producto();
                producto.setCantidad(totaFinal);
                producto.setCodProducto(detalle[i].getCodProducto());
                
                detalles = productoDAO.merge(producto);
            }
            if (detalles) {
                //detalles = generarPDF.generarPDF(detalle[], factura.getPedido());
                return true;
            } else {
                return false;
            }
            
            
        } catch (RuntimeException e) {
            LOGGER.error("FALLO EN LA CREACION DEL PEDIDO", e);
            throw new Exception(e);
        }
    }
    
    /**
     * 
     * @param pedido
     * @return
     * @throws Exception 
     */
    @Override
    public boolean updateCatgoria (Pedido pedido) throws Exception{
        try {
            if (pedido != null || pedido.getCodPedido()!= null ) {
                boolean update = pedidoDAO.merge(pedido);
                return update;
            } else {
                return false;
            }
        } catch (RuntimeException e) {
            LOGGER.error("FALLO EN LA CREACION DEL PEDIDO", e);
            throw new Exception(e);
        }
    }
    
    /**
     * 
     * @param Pedido
     * @return
     * @throws Exception 
     */
    @Override
    public boolean deletCategoria (Pedido Pedido) throws Exception{
        try {
            boolean delet = pedidoDAO.delete(Pedido);
            return delet;
            
        } catch (RuntimeException e) {
            LOGGER.error("FALLO EN LA ELIMINACION DEL PEDIDO", e);
            throw new Exception(e);
        }
    }
}
