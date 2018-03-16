/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito.compras.model.dao;

import carrico.compras.model.mapper.CategoriaProductoMapper;
import carrito.compras.model.CategoriaProducto;
import carrito.compras.model.Producto;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pragma.orm.DataBaseType;
import pragma.orm.SpringPersistenceDAO;

/**
 *
 * @author leonardo.aedo
 */
@Repository
public class CategoriaProductoDAO extends SpringPersistenceDAO<CategoriaProducto>{
    
    
    
    /**
     * 
     * @param dataSource 
     */
    @Autowired
    public CategoriaProductoDAO (DataSource dataSource) {
        super(dataSource, DataBaseType.MYSQL);
    }

    @Autowired
    private Util util;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaProductoDAO.class);
    
    
    /**
     * 
     * @param categorias
     * @param product
     * @return
     * @throws RuntimeException 
     */
    public boolean persist(BigDecimal categorias[], Producto product) throws RuntimeException, SQLException {
        try {
            BigDecimal cod = util.codUltimoProducto(product);
            if (cod.equals(0)) {
                return false;
            } else {
                boolean respuesta = true;
                CategoriaProducto catPro = new CategoriaProducto();
                for (int i = 0; i < categorias.length && respuesta ; i++) {
                    catPro.setCodCategoria(categorias[i]);
                    catPro.setCodProducto(cod);
                    respuesta = super.persist(catPro);
                }
                return respuesta;
            }
        } catch (RuntimeException | SQLException e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean persist(CategoriaProducto e) throws RuntimeException {
        return super.persist(e); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /**
     * 
     * @param categoriaProducto
     * @return
     * @throws RuntimeException 
     */
    @Override
    public boolean delete(CategoriaProducto categoriaProducto) throws RuntimeException {
        return super.delete(categoriaProducto); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<CategoriaProducto> selectByCodProucto (String codCatProd) throws RuntimeException {
        String sql = "SELECT * FROM CATEGORIA_X_PRODUCTO CP WHERE 1=1 ";
        Map<String, Object> parametros = new LinkedHashMap<>();
        if (codCatProd != null && codCatProd.length()>0) {
            sql += "AND UPPER(CP.CATEGORIA_COD_CATEGORIA =:codProducto)";
            parametros.put("codProducto", codCatProd);
        }
        return getNamedParameterJdbcTemplate().query(sql, parametros, new CategoriaProductoMapper());
    }

}
