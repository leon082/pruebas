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
public class Empresa extends Cliente {

    private String nit;
    private String representante;

    public Empresa(String nit, String nom, String r) {
        super(nom);
        this.nit = nit;
        this.representante = r;
    }

    @Override
    public String obtIdentificacion() {
        return nit;
    }

    public String obtRepresentante() {
        return representante;
    }

    public void cambiarRepres(String repres) {
        this.representante = repres;
    }

}
