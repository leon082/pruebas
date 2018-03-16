
package carrito.compras.core.service.impl;

import carrito.compras.core.service.IDetallePedido;
import carrito.compras.model.DetallePedido;
import carrito.compras.model.dao.DetallePedidoDAO;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author leonardo.aedo
 */
@Service
public class DetallePedidoService implements IDetallePedido{
    
    @Autowired
    private DetallePedidoDAO detallePedidoDAO;
    
     private static final Logger LOGGER = LoggerFactory.getLogger(DetallePedidoService.class);
    
    
    /**
     * 
     * @param detallePedido
     * @return true o false
     * @throws Exception 
     */
    
    @Override
    public boolean addDetallePedido (DetallePedido detallePedido) throws Exception{
        try {
            boolean addEstado = detallePedidoDAO.persist(detallePedido);
            return addEstado;
            
        } catch (RuntimeException e) {
            LOGGER.error("FALLO EN LA CREACION DE DETALLE PEDIDO", e);
            throw new Exception(e);
        }
    }
    
    /**
     * 
     * @param detallePedido
     * @return
     * @throws Exception 
     */
    @Override
    public boolean updateDetallePedido (DetallePedido detallePedido) throws Exception{
        try {
            if (detallePedido != null || detallePedido.getCodPedido()!= null ) {
                boolean update = detallePedidoDAO.merge(detallePedido);
                return update;
            } else {
                return false;
            }
        } catch (RuntimeException e) {
            LOGGER.error("FALLO EN LA CREACION DE DETALLE PEDIDO", e);
            throw new Exception(e);
        }
    }
    
    /**
     * 
     * @param detallePedido
     * @return
     * @throws Exception 
     */
    @Override
    public boolean deletDetallePedido (DetallePedido detallePedido) throws Exception{
        try {
            boolean delet = detallePedidoDAO.delete(detallePedido);
            return delet;
            
        } catch (RuntimeException e) {
            LOGGER.error("FALLO EN LA ELIMINACION DE DETALLE PEDIDO", e);
            throw new Exception(e);
        }
    }
    
    /**
     * 
     * @param codProducto
     * @return
     * @throws Exception 
     */
    @Override
    public List<DetallePedido> pedidosCodProducto (String codProducto)throws Exception{
        try {
            return detallePedidoDAO.selectByCodProucto(codProducto);
        } catch (RuntimeException e) {
            LOGGER.error("FALLO EN LA BUSQUEDA DE DETALLE PEDIDO", e);
            throw new Exception(e);
        }
    }
}
