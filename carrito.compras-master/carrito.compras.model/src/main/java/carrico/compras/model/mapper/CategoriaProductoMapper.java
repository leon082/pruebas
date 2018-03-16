/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrico.compras.model.mapper;

import carrito.compras.model.CategoriaProducto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author leonardo.aedo
 */
public class CategoriaProductoMapper implements RowMapper<CategoriaProducto>{
    
    public CategoriaProductoMapper() {
        super();
    }
    
    @Override
    public CategoriaProducto mapRow(ResultSet rs, int rowNuw) throws SQLException {
        CategoriaProducto CP = new CategoriaProducto();
        CP.setCodCategoria(rs.getBigDecimal("CATEGORIA_COD_CATGORIA"));
        CP.setCodProducto(rs.getBigDecimal("PRODUCTO_COD_PRODUCTO"));
        return CP;
    }

}
