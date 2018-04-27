/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pri.aleja.turnero;

/**
 *
 * @author luis.leon
 */
public class Turno {
    //Listar los turnos en orden de llegada, el cajero tendra un estado y un turn
    // 1 solicitado, 2 asignado, 3 terminado
    private int estado;
    private String descripcion;
    private int complejidad;

    public int getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(int complejidad) {
        this.complejidad = complejidad;
    }
    
    

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
