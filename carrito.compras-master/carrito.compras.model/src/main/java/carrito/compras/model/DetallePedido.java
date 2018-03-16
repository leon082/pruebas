
package carrito.compras.model;

import java.math.BigDecimal;
import pragma.orm.annotation.Attribute;
import pragma.orm.annotation.Entity;

/**
 *
 * @author leonardo.aedo
 */
@Entity (name = "DETALLE_PEDIDO")
public class DetallePedido {
    
    @Attribute (name = "PRODUCTO_COD_PRODUCTO")
    private BigDecimal codProducto;
    
    @Attribute (name = "PEDIDO_COD_PEDIDO")
    private BigDecimal codPedido;
    
    @Attribute (name = "CANTIDAD")
    private String cantidad;
    
    private String cantidadCompra;

    public BigDecimal getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(BigDecimal codProducto) {
        this.codProducto = codProducto;
    }

    public BigDecimal getCodPedido() {
        return codPedido;
    }

    public String getCantidadCompra() {
        return cantidadCompra;
    }
    
    public void setCodPedido(BigDecimal codPedido) {
        this.codPedido = codPedido;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public void setCantidadCompra(String cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }
    
    
}
