/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito.cmpras.core.pojo;

import carrito.compras.model.DetallePedido;
import carrito.compras.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author leonardo.aedo
 */
public class facturaProductos {
    
    @Autowired
    private Pedido pedido;
    
    @Autowired
    private DetallePedido detallePedido [];

    public Pedido getPedido() {
        return pedido;
    }

    public DetallePedido[] getDetallePedido() {
        return detallePedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setDetallePedido(DetallePedido[] detallePedido) {
        this.detallePedido = detallePedido;
    }
    
    
    
}
