/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito.compras.model;

import java.math.BigDecimal;
import pragma.orm.annotation.Attribute;
import pragma.orm.annotation.Entity;

/**
 *
 * @author leonardo.aedo
 */
@Entity (name = "CATEGORIA_X_PRODUCTO")
public class CategoriaProducto {
    
    @Attribute (name = "CATEGORIA_COD_CATEGORIA", key = true)
    private BigDecimal codCategoria;

    @Attribute (name = "PRODUCTO_COD_PRODUCTO", key = true)
    private BigDecimal codProducto;
    
    @Attribute (name = "ESTADO")
    private String estado;
    
    public BigDecimal getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(BigDecimal codCategoria) {
        this.codCategoria = codCategoria;
    }

    public BigDecimal getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(BigDecimal codProducto) {
        this.codProducto = codProducto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
