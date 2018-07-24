/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author luis.leon
 */
public abstract  class Cliente {

    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String obtNombre() {
        return nombre;
    }

    public abstract String obtIdentificacion();

}
