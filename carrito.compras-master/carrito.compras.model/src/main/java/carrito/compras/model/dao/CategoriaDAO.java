package carrito.compras.model.dao;

import carrito.compras.model.Categoria;
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
import carrico.compras.model.mapper.CategoriaMappper;

/**
 *
 * @author leonardo.aedo
 */
@Repository
public class CategoriaDAO extends SpringPersistenceDAO<Categoria> {

    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private Util util;

     private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaDAO.class);
    /**
     *
     * @param dataSource
     */
    @Autowired
    public CategoriaDAO(DataSource dataSource) {
        super(dataSource, DataBaseType.MYSQL);
    }

   /**
    * 
    * @param categoria
    * @return
    * @throws RuntimeException 
    */
    @Override
    public boolean persist(Categoria categoria) throws RuntimeException{
        try {
            BigDecimal cod = util.codTablas("CODIGO_TABLA", "COD_CATEGORIA");
            if (cod.equals(0)) {
                return false;
            } else {
                categoria.setCodCategoria(cod);
                return super.persist(categoria);
            }
        } catch (RuntimeException | SQLException e) {
            LOGGER.error(e.getMessage(),e);
            return false;
        }
    }

    /**
     * Metodo encargado de acctualizar registros en la base de datos
     *
     * @param categoria
     * @return
     * @throws RuntimeException
     */
    @Override
    public boolean merge(Categoria categoria) throws RuntimeException {
        return super.merge(categoria); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param categoria
     * @return
     * @throws RuntimeException
     */
    @Override
    public boolean delete(Categoria categoria) throws RuntimeException {
        return super.delete(categoria); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return @throws RuntimeException
     */
    @Override
    public List<Categoria> selectAll() throws RuntimeException {
        return super.selectAll(); //To change body of generated methods, choose Tools | Templates.
    }

    public Categoria selectByKey(final BigDecimal codCategoria) throws RuntimeException, SQLException {
        if (codCategoria != null) {
            Map<String, Object> categoria = new LinkedHashMap<>();
            categoria.put("COD_CATEGORIA", codCategoria);
            return  super.selectByKey(categoria);
        }else{
            return null;
        }
    }

    public List<Categoria> searchByParams (Categoria categoria) throws RuntimeException{
        Map <String,Object> params = new LinkedHashMap<>();
        String sql = "SELECT * FROM CATEGORIA C WHERE (1 = 1) ";
        if (categoria.getDescripcion() != null && categoria.getDescripcion().length()>0) {
            sql += "AND UPPER (C.DESCRIPCION LIKE UPPER ('%' :descripcion '%'))";
            params.put("descripcion", categoria.getDescripcion());
        }
        if (categoria.getEstado() != null && categoria.getEstado().length() >=0) {
            sql +=  "AND (C.ESTADO LIKE :estado)";
            params.put("estado", categoria.getEstado());
        }
        return getNamedParameterJdbcTemplate().query(sql, params, new CategoriaMappper());
    }
}
