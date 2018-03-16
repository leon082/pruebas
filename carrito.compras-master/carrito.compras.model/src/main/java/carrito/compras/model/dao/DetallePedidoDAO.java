
package carrito.compras.model.dao;

import carrico.compras.model.mapper.DetallePedidoMapper;
import carrito.compras.model.DetallePedido;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
public class DetallePedidoDAO extends SpringPersistenceDAO<DetallePedido>{
    
    @Autowired
    public DetallePedidoDAO (DataSource dataSource){
        super(dataSource, DataBaseType.MYSQL);
    }

    /**
     * 
     * @param detallePedido
     * @return
     * @throws RuntimeException 
     */
    @Override
    public boolean merge(DetallePedido detallePedido) throws RuntimeException {
        return super.merge(detallePedido); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param DetallePedido
     * @return
     * @throws RuntimeException 
     */
    @Override
    public boolean persist(DetallePedido DetallePedido) throws RuntimeException {
        return super.persist(DetallePedido); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param detallePedido
     * @return
     * @throws RuntimeException 
     */
    @Override
    public boolean delete(DetallePedido detallePedido) throws RuntimeException {
        return super.delete(detallePedido); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     * @param codProducto
     * @return
     * @throws RuntimeException 
     */
    public List<DetallePedido> selectByCodProucto (String codProducto) throws RuntimeException {
        String sql = "SELECT * FROM DETALLE_PEDIDO DP WHERE 1=1 ";
        Map<String, Object> parametros = new LinkedHashMap<>();
        if (codProducto != null && codProducto.length()>0) {
            sql += "AND UPPER(DP.PRODUCTO_COD_PRODUCTO =:codProducto)";
            parametros.put("codProducto", codProducto);
        }
        return getNamedParameterJdbcTemplate().query(sql, parametros, new DetallePedidoMapper());
    }
    
    
}
