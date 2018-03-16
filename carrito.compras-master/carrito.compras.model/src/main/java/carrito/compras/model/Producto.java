package carrito.compras.model;

import java.math.BigDecimal;
import java.util.List;
import pragma.orm.annotation.Attribute;
import pragma.orm.annotation.Entity;

/**
 *
 * @author leonardo.aedo
 */
@Entity (name = "PRODUCTO")
public class Producto {
    
    @Attribute (name = "COD_PRODUCTO", key = true)
    private BigDecimal codProducto;

    @Attribute (name = "NOMBRE_PRODUCTO")
    private String nombreProducto;
    
    @Attribute (name = "DESCRIPCION_PRODUCTO")
    private String descProducto;
    
    @Attribute (name = "PRECIO")
    private BigDecimal precio;
    
    @Attribute (name = "CANTIDAD")
    private BigDecimal cantidad;
    
    @Attribute (name = "FOTO")
    private String foto;
    
    @Attribute (name = "ESTADO")
    private String estado;
    
    private int cantidadCompra;
    
    private int valorMayor;
    
    private int valorMenor;

    private List<Categoria> Categorias;
    
    public BigDecimal getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(BigDecimal codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescProducto() {
        return descProducto;
    }

    public void setDescProducto(String descProducto) {
        this.descProducto = descProducto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }
    
    public int getCantidadCompra() {
        return cantidadCompra;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCantidadCompra(int cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }

    public int getValorMayor() {
        return valorMayor;
    }

    public void setValorMayor(int valorMayor) {
        this.valorMayor = valorMayor;
    }

    public int getValorMenor() {
        return valorMenor;
    }

    public void setValorMenor(int valorMenor) {
        this.valorMenor = valorMenor;
    }

    public List<Categoria> getCategorias() {
        return Categorias;
    }

    public void setCategorias(List<Categoria> Categorias) {
        this.Categorias = Categorias;
    }
    
    

    
}
