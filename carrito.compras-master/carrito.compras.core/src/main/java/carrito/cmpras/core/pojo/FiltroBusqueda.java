package carrito.cmpras.core.pojo;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author leonardo.aedo
 */
public class FiltroBusqueda {
    @Autowired
    private int categoriasFiltro;
    
    @Autowired
    private String descripcion;
    
    @Autowired
    private BigDecimal precioMenor;
    
    @Autowired 
    private BigDecimal precioMayor;
    
    @Autowired
    private String estado;
    
    @Autowired
    private String nombre;

    public int getCategoriasFiltro() {
        return categoriasFiltro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public BigDecimal getPrecioMenor() {
        return precioMenor;
    }

    public BigDecimal getPrecioMayor() {
        return precioMayor;
    }

    public String getEstado() {
        return estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCategoriasFiltro(int categoriasFiltro) {
        this.categoriasFiltro = categoriasFiltro;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioMenor(BigDecimal precioMenor) {
        this.precioMenor = precioMenor;
    }

    public void setPrecioMayor(BigDecimal precioMayor) {
        this.precioMayor = precioMayor;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
