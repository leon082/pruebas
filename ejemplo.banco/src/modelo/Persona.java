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
public class Persona extends Cliente {

    private String cedula;
    private int edad;

    public Persona(String ced, String nom, int ed) {
        super(nom);
        this.cedula = ced;
        this.edad = ed;
    }

    @Override
    public String obtIdentificacion() {
        return cedula;
    }

    public String obtEdad() {
        return String.valueOf(edad);
    }

    public void cumplirAños() {
        this.edad = edad + 1;
    }

}
