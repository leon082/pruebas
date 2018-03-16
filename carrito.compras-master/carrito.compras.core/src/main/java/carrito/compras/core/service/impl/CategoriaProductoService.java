/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito.compras.core.service.impl;

import carrito.cmpras.core.pojo.CategoriaPorProducto;
import carrito.compras.core.service.ICategoriaProducto;
import carrito.compras.model.CategoriaProducto;
import carrito.compras.model.Producto;
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
public class CategoriaProductoService implements ICategoriaProducto{
    
    @Autowired
    private CategoriaProductoDAO catProductoDAO;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaProductoService.class);
      
    /**
     * 
     * @param categoriaProducto
     * @return
     * @throws Exception 
     */
    @Override
    public boolean addCategoriaProducto (CategoriaPorProducto catePorProducto) throws Exception{
        try {
            BigDecimal categorias [] = new BigDecimal[catePorProducto.getCategoria().length];
            int categoriasInt [] = catePorProducto.getCategoria();
            for (int i = 0; i < categoriasInt.length; i++) {
                categorias [i] = BigDecimal.valueOf(categoriasInt[i]) ;
            }
            
            Producto producto = catePorProducto.getProducto();
            boolean addCategoria = catProductoDAO.persist(categorias, producto);
            return addCategoria;
            
        } catch (RuntimeException e) {
            LOGGER.error("FALLO EN LA CREACION DE LA CATEGORIA_PRODUCTO", e);
            throw new Exception(e);
        }
    }
  
   /**
    * 
    * @param categoriaProducto
    * @return
    * @throws Exception 
    */
    @Override
    public boolean deletCategoriaProducto(CategoriaProducto categoriaProducto) throws Exception {
        try {
            boolean delet = catProductoDAO.delete(categoriaProducto);
            return delet;
            
        } catch (RuntimeException e) {
            LOGGER.error("FALLO EN LA ELIMINACION DE LA CATEGORIA_PRODUCTO", e);
            throw new Exception(e);
        }
    }
    
    @Override
    public List<CategoriaProducto> selectByCodProucto (String codProducto)throws Exception{
        try {
            return catProductoDAO.selectByCodProucto(codProducto);
        } catch (RuntimeException e) {
            LOGGER.error("FALLO EN LA BUSQUEDA DE DETALLE PEDIDO", e);
            throw new Exception(e);
        }
    }

   
}
