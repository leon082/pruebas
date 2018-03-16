/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrico.compras.model.mapper;

import carrito.compras.model.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author leonardo.aedo
 */
public class ProductoMapper implements RowMapper<Producto>{

    public ProductoMapper() {
        super();
    }
    
    @Override
    public  Producto mapRow (ResultSet rs, int rowNuw) throws SQLException {
        Producto P = new Producto();
        P.setCodProducto(rs.getBigDecimal("COD_PRODUCTO"));
        P.setNombreProducto(rs.getString("NOMBRE_PRODUCTO"));
        P.setDescProducto(rs.getString("DESCRIPCION_PRODUCTO"));
        P.setPrecio(rs.getBigDecimal("PRECIO"));
        P.setCantidad(rs.getBigDecimal("CANTIDAD"));
        P.setFoto(rs.getString("FOTO"));
        P.setEstado(rs.getString("ESTADO"));
        return P;
    }
}
