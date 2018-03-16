
package carrito.compras.core.service;

import carrito.compras.model.Categoria;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author leonardo.aedo
 */
public interface ICategoriaService {
    
    public boolean addCategoria (Categoria categoria) throws Exception;  
     
    public boolean updateCatgoria (Categoria categoria) throws Exception;
      
    public boolean deletCategoria (Categoria categoria) throws Exception;
      
    public List<Categoria> categorias () throws Exception;
    
    public Categoria categoriasById (BigDecimal codCategoria) throws Exception;
    
    public List<Categoria> searchByParams (Categoria categoria)throws Exception;
}
