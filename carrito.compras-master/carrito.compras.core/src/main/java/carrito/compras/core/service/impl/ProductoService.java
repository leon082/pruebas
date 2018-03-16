
package carrito.compras.core.service.impl;

import carrito.cmpras.core.pojo.CategoriaPorProducto;
import carrito.cmpras.core.pojo.FiltroBusqueda;
import carrito.compras.core.service.IProductoService;
import carrito.compras.model.Producto;
import carrito.compras.model.Categoria;
import carrito.compras.model.CategoriaProducto;
import carrito.compras.model.dao.ProductoDAO;
import carrito.compras.model.dao.CategoriaDAO;
import carrito.compras.model.dao.CategoriaProductoDAO;
import java.math.BigDecimal;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author leonardo.aedo
 */
@Service
public class ProductoService implements IProductoService{
    
    @Autowired
    private ProductoDAO productoDAO;
    
    @Autowired
    private CategoriaDAO categoriaDAO;
    
    @Autowired
    private CategoriaProductoDAO categoriaProductoDAO;
    
    
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoService.class);
    
    /**
    * 
    * @param producto
    * @return
    * @throws Exception 
    */
    @Override
    public boolean add (Producto producto) throws Exception{
        boolean creado = false;
        try {
            if (producto != null) {
                BigDecimal codProducto = productoDAO.add(producto);
                CategoriaProducto categoriaProducto = new CategoriaProducto();
                for (int i = 0; i < producto.getCategorias().size(); i++) {
                    categoriaProducto.setCodCategoria(producto.getCategorias().get(i).getCodCategoria());
                    categoriaProducto.setCodProducto(codProducto);
                    creado = categoriaProductoDAO.persist(categoriaProducto);
                }
            return creado;
            } else {
                return creado;
            }
        } catch (RuntimeException e) {
        LOGGER.error("FALLO EN LA CREACION DEL PRODUCTO", e);
            throw new Exception(e);
        }
    }
    
    /**
     * 
     * @param producto
     * @return
     * @throws Exception 
     */
    @Override
    public boolean edit (Producto producto) throws Exception{
        try {
            boolean actualizado = false;
            if (producto != null) {
                actualizado = productoDAO.merge(producto);
                if (producto.getCategorias() != null && producto.getCategorias().size() > 0) {
                    List<Categoria> categorias = producto.getCategorias();
                    CategoriaProducto categoriaProducto = new CategoriaProducto();
                    for (int i = 0; i < categorias.size(); i++) {
                        categoriaProducto.setCodCategoria(categorias.get(i).getCodCategoria());
                        categoriaProducto.setCodProducto(producto.getCodProducto());
                        if (categorias.get(i).getEstado().equalsIgnoreCase("Activo")) {
                            try {
                                categoriaProducto.setEstado("Activo");
                                actualizado = categoriaProductoDAO.persist(categoriaProducto);
                            } catch (RuntimeException e) {
                                categoriaProducto.setEstado("Activo");
                                actualizado = categoriaProductoDAO.merge(categoriaProducto);
                                LOGGER.error("FALLO EN LA ACTUALIZACION DE LA CATEGORIA DEL PRODUCTO", e);

                            }
                        } else {
                            categoriaProducto.setEstado("Inactivo");
                            actualizado = categoriaProductoDAO.merge(categoriaProducto);
                        }
                    }
                }
                
            }
            return actualizado;
        } catch (RuntimeException e) {
        LOGGER.error("FALLO EN LA ACTUALIZACION DEL PRODUCTO", e);
            throw new Exception(e);
        }
    }
    
    /**
     * 
     * @param producto
     * @return
     * @throws Exception 
     */
    @Override
    public boolean deletproducto (Producto producto) throws Exception{
        try {
            boolean delet = productoDAO.delete(producto);
            return delet;
            
        } catch (RuntimeException e) {
            LOGGER.error("FALLO EN LA ELIMINACION DEL PRODUCTO", e);
            throw new Exception(e);
        }
    }
    
    /**
     * 
     * @return
     * @throws Exception 
     */
    @Override
    public List<Producto> productos ()throws Exception{
        try {
            return productoDAO.selectAll();
        } catch (RuntimeException e) {
            LOGGER.error("FALLO EN LA BUSQUEDA DE LOS PRODUCTOS", e);
            throw new Exception(e);
        }
    }
    
    /**
     * 
     * @param codProducto
     * @return
     * @throws Exception 
     */
    @Override
    public Producto selectByKey(BigDecimal codProducto) throws Exception{
        try {
            Producto producto = productoDAO.selectByKey(codProducto);
            List<Categoria> categoriasProducto = productoDAO.selectCategoriasByKey(codProducto);
            Categoria categoria = new Categoria();
            categoria.setEstado("Activo");
            List<Categoria> categoriaAll = categoriaDAO.searchByParams(categoria);
            for (int i = 0; i < categoriasProducto.size(); i++) {
                boolean enLista = false;
                for (int j = 0; j < categoriaAll.size()  && enLista == false ; j++) {
                    if (categoriaAll.get(j).equals(categoriasProducto.get(i))) {
                        categoriaAll.get(j).setEstado("Activo");
                        enLista = true;
                    }
                }
            }
            producto.setCategorias(categoriaAll);
            return producto;
        } catch (RuntimeException e) {
            LOGGER.error("FALLO EN LA BUSQUEDA DEL PRODUCTO", e);
            throw new Exception(e);
        }
    }
    
    @Override
    public List<Producto> searchByParams(Producto producto) throws Exception{
        try {
            return productoDAO.searchByParams(producto);
        } catch (RuntimeException e) {
            LOGGER.error("FALLO EN LA BUSQUEDA DEL PRODUCTO", e);
            throw new Exception(e);
        }
    }
    
    @Override
    public List<Producto> FiltroUusario (FiltroBusqueda filtro) throws Exception{
        try {
            BigDecimal precioMenor = filtro.getPrecioMenor();
            BigDecimal precioMayor = filtro.getPrecioMayor();
            String descripcion = filtro.getDescripcion();
            int codCategoria = filtro.getCategoriasFiltro();
            String estado = filtro.getEstado();
            String nombre = filtro.getNombre();
            return productoDAO.FiltroUusario(precioMenor, precioMayor, descripcion, codCategoria, estado, nombre);
        } catch (RuntimeException e) {
            LOGGER.error("Fallo en el filtrado", e);
            throw new Exception (e);
        }
    }
}
