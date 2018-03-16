/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito.compras.model.dao;

import carrico.compras.model.mapper.ProductoMapper;
import carrito.compras.model.Producto;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.LinkedHashMap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author leonardo.aedo
 */
@Repository
public class Util {

    @Autowired
    private DataSource dataSource;

    public BigDecimal codTablas(String tabla, String columna) throws SQLException {
        Connection conn = dataSource.getConnection();
        String sql = "SELECT " + columna + " FROM " + tabla;

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        BigDecimal cod = null;
        int resultado = -1;
        if (rs.next()) {
            cod = rs.getBigDecimal(columna);
            cod = cod.add(new BigDecimal(1));
            
            sql = "UPDATE " + tabla + " SET " + columna + " =  (?)";
            ps = conn.prepareStatement(sql);
            ps.setBigDecimal(1, cod);

            resultado = ps.executeUpdate();
            if (resultado == 1 || resultado == 2) {
                
            } else {
                cod = BigDecimal.ZERO;
            }
        }
        ps.close();
        rs.close();

        return cod;
    }
    public BigDecimal codUltimoProducto(Producto producto) throws SQLException {
        String sql = "SELECT COD_PRODUCTO FROM PRODUCTO P  WHERE (1=1) "
                + "AND UPPER (P.DESCRIPCION_PRODUCTO LIKE UPPER (?)) "
                + "AND UPPER (P.ESTADO LIKE UPPER(?)) "
                + "AND UPPER (P.NOMBRE_PRODUCTO LIKE UPPER (?)) "
                + "AND (P.PRECIO LIKE ?) "
                + "AND (P.CANTIDAD LIKE ?)";

        Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, producto.getDescProducto());
        ps.setString(2, producto.getEstado());
        ps.setString(3, producto.getNombreProducto());
        ps.setBigDecimal(4, producto.getPrecio());
        ps.setBigDecimal(5, producto.getCantidad());

        ResultSet rs = ps.executeQuery();
        BigDecimal cod = BigDecimal.ZERO;
        if (rs.next()) {
            cod = rs.getBigDecimal(1);
        }

        ps.close();
        rs.close();

        return cod;

    }
}
