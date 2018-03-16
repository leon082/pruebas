
package carrito.compras.core.service;

import carrito.cmpras.core.pojo.CategoriaPorProducto;
import carrito.compras.model.Categoria;
import carrito.compras.model.CategoriaProducto;
import java.util.List;

/**
 *
 * @author leonardo.aedo
 */
public interface ICategoriaProducto {
    
    public boolean addCategoriaProducto (CategoriaPorProducto catePorProducto) throws Exception; 
    
    public boolean deletCategoriaProducto (CategoriaProducto categoriaProducto) throws Exception;
    
    public List<CategoriaProducto> selectByCodProucto (String codString)throws Exception;
    
}
