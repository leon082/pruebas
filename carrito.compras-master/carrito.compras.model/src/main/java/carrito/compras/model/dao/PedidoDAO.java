
package carrito.compras.model.dao;

import carrito.compras.model.Pedido;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pragma.orm.DataBaseType;
import pragma.orm.SpringPersistenceDAO;

/**
 *
 * @author leonardo.aedo
 */
@Repository
public class PedidoDAO extends SpringPersistenceDAO<Pedido>{
    
    @Autowired
    public PedidoDAO (DataSource dataSource){
        super(dataSource, DataBaseType.MYSQL);
    }
    
    @Autowired
    private Util util;

    
    public BigDecimal add (Pedido pedido) throws RuntimeException {
        BigDecimal cod = BigDecimal.ZERO;
        try {
            cod = util.codTablas("CODIGO_TABLA", "COD_PEDIDO");
            pedido.setCodPedido(cod);
            super.persist(pedido);
            return cod;
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return cod;
        }
    }

    /**
     * 
     * @param pedido
     * @return
     * @throws RuntimeException 
     */
    @Override
    public boolean merge(Pedido pedido) throws RuntimeException {
        return super.merge(pedido); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param e
     * @return
     * @throws RuntimeException 
     */
    @Override
    public boolean delete(Pedido e) throws RuntimeException {
        return super.delete(e); //To change body of generated methods, choose Tools | Templates.
    }
}
