
package carrito.compras.model;

import java.math.BigDecimal;
import java.util.Date;
import pragma.orm.annotation.Attribute;
import pragma.orm.annotation.Entity;

/**
 *
 * @author leonardo.aedo
 */

@Entity (name = "PEDIDO")
public class Pedido {
    
    @Attribute (name = "COD_PEDIDO", key = true )
    private BigDecimal codPedido;

    @Attribute (name = "FECHA")
    private Date fecha;
    
    @Attribute (name = "PAIS")
    private String pais;
    
    @Attribute (name = "DEPARTAMENTO")
    private String departamento;
    
    @Attribute (name = "CIUDAD")
    private String ciudad;
    
    @Attribute (name = "DIRECCION")
    private String direccion;
    
    @Attribute (name = "TELEFONO_FIJO")
    private String telefonoFijo;
    
    @Attribute (name = "TELEFONO_CELULAR")
    private String telefonoCelular;
    
    public BigDecimal getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(BigDecimal codPedido) {
        this.codPedido = codPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

}
