/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrico.compras.model.mapper;

import carrito.compras.model.Categoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author leonardo.aedo
 */
public class CategoriaMappper implements RowMapper<Categoria>{
    
    public CategoriaMappper() {
        super();
    }
    
    @Override
    public Categoria mapRow(ResultSet rs, int rowNuw) throws SQLException {
        Categoria CT = new Categoria();
        CT.setCodCategoria(rs.getBigDecimal("COD_CATEGORIA"));
        CT.setDescripcion(rs.getString("DESCRIPCION"));
        return CT;
    }

}
