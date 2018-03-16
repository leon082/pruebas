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

@Entity (name = "CATEGORIA")
public class Categoria {
    
    @Attribute (name = "COD_CATEGORIA", key = true )
    private BigDecimal codCategoria ;
    
    @Attribute (name = "DESCRIPCION")
    private String descripcion;
    
    @Attribute (name = "ESTADO")
    private String estado;

    public BigDecimal getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(BigDecimal codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object obj) {
        boolean retorno = false;
        if(obj instanceof Categoria){
            Categoria b = (Categoria) obj;
            retorno = this.codCategoria.equals(b.codCategoria);
        }
        return retorno;
    }

    
    
}
