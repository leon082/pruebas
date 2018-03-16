/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito.cmpras.core.pojo;

import carrito.compras.model.Producto;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author leonardo.aedo
 */
public class CategoriaPorProducto {
    
    @Autowired
    private Producto producto;
    
    @Autowired
    private int categoria[];
    
   

    public Producto getProducto() {
        return producto;
    }

    public int []getCategoria() {
        return categoria;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCategoria(int [] categoria) {
        this.categoria = categoria;
    }
    
}
