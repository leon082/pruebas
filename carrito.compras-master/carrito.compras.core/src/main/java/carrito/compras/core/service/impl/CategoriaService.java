/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito.compras.core.service.impl;

import carrito.compras.core.service.ICategoriaService;
import carrito.compras.model.Categoria;
import carrito.compras.model.dao.CategoriaDAO;
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
public class CategoriaService implements ICategoriaService{
    
    @Autowired
    private CategoriaDAO categoriaDAO;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaService.class);
    
    /**
     * 
     * @param categoria
     * @return true o false
     * @throws Exception 
     */
    
    @Override
    public boolean addCategoria (Categoria categoria) throws Exception{
        try {
            boolean addEstado = categoriaDAO.persist(categoria);
            return addEstado;
            
        } catch (Exception e) {
            LOGGER.error("FALLO EN LA CREACION DE LA CATEGORIA", e);
            throw new Exception(e);
        }
    }
    
    /**
     * 
     * @param categoria
     * @return
     * @throws Exception 
     */
    public boolean updateCatgoria (Categoria categoria) throws Exception{
        try {
            if (categoria != null || categoria.getCodCategoria()!= null ) {
                boolean update = categoriaDAO.merge(categoria);
                return update;
            } else {
                return false;
            }
        } catch (RuntimeException e) {
            LOGGER.error("FALLO EN LA CREACION DE LA CATEGORIA", e);
            throw new Exception(e);
        }
    }
    
    /**
     * 
     * @param categoria
     * @return
     * @throws Exception 
     */
    @Override
    public boolean deletCategoria (Categoria categoria) throws Exception{
        try {
            boolean delet = categoriaDAO.delete(categoria);
            return delet;
            
        } catch (RuntimeException e) {
            LOGGER.error("FALLO EN LA ELIMINACION DE LA CATEGORIA", e);
            throw new Exception(e);
        }
    }
    
    /**
     * 
     * @return
     * @throws Exception 
     */
    @Override
    public List<Categoria> categorias ()throws Exception{
        try {
            return categoriaDAO.selectAll();
        } catch (RuntimeException e) {
            LOGGER.error("FALLO EN LA BUSQUEDA DE LAS CATEGORIA", e);
            throw new Exception(e);
        }
    }
    
    @Override
    public Categoria categoriasById (BigDecimal codCategoria)throws Exception{
        try {
            return categoriaDAO.selectByKey(codCategoria);
        } catch (Exception e) {
            LOGGER.error("FALLO EN LA BUSQUEDA DE LAS CATEGORIA", e);
            throw new Exception(e);
        }
    }
    
    @Override
    public List<Categoria> searchByParams (Categoria categoria)throws Exception{
        try {
            return categoriaDAO.searchByParams(categoria);
        } catch (Exception e) {
            LOGGER.error("FALLO EN LA BUSQUEDA DE LAS CATEGORIA", e);
            throw new Exception(e);
        }
    }
}
