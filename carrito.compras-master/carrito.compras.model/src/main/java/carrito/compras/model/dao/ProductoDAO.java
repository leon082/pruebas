
package carrito.compras.model.dao;

import carrico.compras.model.mapper.ProductoMapper;
import carrico.compras.model.mapper.CategoriaMappper;
import carrito.compras.model.Categoria;
import carrito.compras.model.Producto;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
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
public class ProductoDAO extends SpringPersistenceDAO<Producto>{
    
    @Autowired
    private Util util;
    
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ProductoDAO.class);
    
     /**
     * 
     * @param dataSource 
     */
    @Autowired
    public ProductoDAO (DataSource dataSource) {
        super(dataSource, DataBaseType.MYSQL);
    }

    /**
     * 
     * @param producto
     * @return
     * @throws RuntimeException 
     */
    public BigDecimal add (Producto producto) throws RuntimeException {

        BigDecimal cod = BigDecimal.ZERO;
        try {
            cod = util.codTablas("CODIGO_TABLA","COD_PRODUCTO");
            producto.setCodProducto(cod);
            boolean add = super.persist(producto);
            if (add) {
                return cod;
            }else{
            return cod;}
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(),ex);
            return cod;
        }
        
        
    }

    /**
     * 
     * @param producto
     * @return
     * @throws RuntimeException 
     */
    @Override
    public boolean merge(Producto producto) throws RuntimeException {
        return super.merge(producto); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param producto
     * @return
     * @throws RuntimeException 
     */
    @Override
    public boolean delete(Producto producto) throws RuntimeException {
        return super.delete(producto); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return
     * @throws RuntimeException 
     */
    @Override
    public List<Producto> selectAll() throws RuntimeException {
        return super.selectAll(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param codProducto
     * @return
     * @throws RuntimeException 
     */
    public Producto selectByKey(BigDecimal codProducto) throws RuntimeException {
        if (codProducto != null) {
            Map<String, Object> productos = new LinkedHashMap<>();
            productos.put("COD_PRODUCTO", codProducto);
            return  super.selectByKey(productos);
        }else{
            return null;
        }
        
    }
    
    public List<Categoria> selectCategoriasByKey(BigDecimal codProducto) throws RuntimeException {
        if (codProducto != null) {
            String sql = "SELECT C.COD_CATEGORIA, C.DESCRIPCION FROM PRODUCTO P, CATEGORIA_X_PRODUCTO CxP, CATEGORIA C WHERE (CxP.ESTADO = 'Activo') AND (C.COD_CATEGORIA = CxP.CATEGORIA_COD_CATEGORIA) AND (P.COD_PRODUCTO = CxP.PRODUCTO_COD_PRODUCTO) AND (COD_PRODUCTO = :codProducto)";
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("codProducto", codProducto);
            return getNamedParameterJdbcTemplate().query(sql, params, new CategoriaMappper());
        }else{
            return null;
        }
        
    }
    
    public List<Producto> searchByParams (Producto producto) throws  RuntimeException{
            if (producto != null) {
                String sql = "SELECT * FROM PRODUCTO P WHERE (1=1)";
                Map<String, Object> productoParams = new LinkedHashMap<>();
                if (producto.getCodProducto() != null && producto.getCodProducto().longValue()>0) {
                    sql += " AND (P.COD_PRODUCTO = :codProducto)";
                    productoParams.put("codProducto", producto.getCodProducto());
                }
                if (producto.getDescProducto() != null && producto.getDescProducto().length()>0) {
                    sql += " AND UPPER (P.DESCRIPCION_PRODUCTO LIKE UPPER ('%' :descProducto '%'))";
                    productoParams.put("descProducto", producto.getDescProducto());
                }
                if (producto.getEstado() != null && producto.getEstado().length()>0) {
                    sql += " AND UPPER(P.ESTADO LIKE UPPER(:estado))";
                    productoParams.put("estado", producto.getEstado());
                }
                if (producto.getNombreProducto() != null && producto.getNombreProducto().length()>0) {
                    sql += " AND UPPER(P.NOMBRE_PRODUCTO LIKE UPPER ('%' :nombreProducto '%')) ";
                    productoParams.put("nombreProducto", producto.getNombreProducto());
                }
                if (producto.getPrecio() != null && producto.getPrecio().longValue()>0) {
                    sql += " AND (P.PRECIO LIKE :precio)";
                    productoParams.put("precio", producto.getPrecio());
                }
                if (producto.getCantidad() != null && producto.getCantidad().longValue()>0) {
                    sql += " AND (P.CANTIDAD LIKE :cantidad)";
                    productoParams.put("cantidad", producto.getCantidad());
                }
                if (producto.getValorMenor() >0) {
                    sql += "AND UPPER (P.PRECIO < :precioMenor)";
                    productoParams.put("precioMenor", producto.getValorMenor());
                }
                if (producto.getValorMayor()>0) {
                    sql += "AND UPPER (P.PRECIO > :precioMayor)";
                    productoParams.put("precioMayor", producto.getValorMayor());
                }
                return getNamedParameterJdbcTemplate().query(sql, productoParams, new ProductoMapper());
                
            } else {
                return null;
            }
    }
    
    public List<Producto> FiltroUusario (BigDecimal precioMenor, BigDecimal precioMayor, String descripcion, int codCategoria, String estado, String nombre) throws RuntimeException{
        Map <String,Object> params = new LinkedHashMap<>();
        String sql = "SELECT P.* FROM  PRODUCTO P INNER JOIN (CATEGORIA_X_PRODUCTO CxP INNER JOIN "
                   + "CATEGORIA C ON CxP.CATEGORIA_COD_CATEGORIA = C.COD_CATEGORIA) "
                   + "ON P.COD_PRODUCTO = CxP.PRODUCTO_COD_PRODUCTO WHERE (P.ESTADO = 'ACTIVO')";
        if (estado != null && estado.length() > 0) {
            sql += " AND UPPER(P.ESTADO LIKE UPPER(:estado))";
            params.put("estado", estado);
        }
        if (nombre != null && nombre.length() > 0) {
            sql += " AND UPPER(P.NOMBRE_PRODUCTO LIKE UPPER ('%' :nombreProducto '%')) ";
            params.put("nombreProducto", nombre);
        }
        if (precioMenor != null) {
            sql += "AND UPPER (P.PRECIO < :precioMenor)";
            params.put("precioMenor", precioMenor);
        }
        if (precioMayor != null) {
            sql += "AND UPPER (P.PRECIO > :precioMayor)";
            params.put("precioMayor", precioMayor);
        }
        if (descripcion != null) {
            sql += "AND UPPER (P.DESCRIPCION_PRODUCTO LIKE UPPER ('%' :descripcion '%'))";
            params.put("descripcion", descripcion);
        }
        if (codCategoria > 0) {
                sql += "AND UPPER (C.COD_CATEGORIA = :codCategoria)";
                params.put("codCategoria",codCategoria );
        }
        sql += "GROUP BY P.COD_PRODUCTO";
        return getNamedParameterJdbcTemplate().query(sql, params, new ProductoMapper());
    }

}
