
package carrico.compras.model.mapper;

import carrito.compras.model.DetallePedido;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author leonardo.aedo
 */
public class DetallePedidoMapper implements RowMapper<DetallePedido>{

    public DetallePedidoMapper() {
        super();
    }
    
    @Override
    public DetallePedido mapRow(ResultSet rs, int rowNuw) throws SQLException {
        DetallePedido DP = new DetallePedido();
        DP.setCantidad(rs.getString("CATIDAD_PRODUCTO"));
        DP.setCodPedido(rs.getBigDecimal("PRODUCTO_COD_PRODUCTO"));
        DP.setCodPedido(rs.getBigDecimal("PEDIDO_COD_PEDIDO"));
        return DP;
    }
    
}
