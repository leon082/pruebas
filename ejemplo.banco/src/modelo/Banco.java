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
public class Banco {
    
    private String nombre;
    private final Cliente clientes[]= new Cliente[10];
    int numeroDeClientes;

    public Banco(String nombre) {
        this.nombre = nombre;
        numeroDeClientes=0;
    }
    
    public String obtNombre(){
        return this.nombre;
    }
    
    public void cambiarNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void adCliente(Cliente cliente){
        this.clientes[numeroDeClientes]=cliente;
        this.numeroDeClientes++;
    }
    
    public int obtNumClientes(){
        return numeroDeClientes;
    }
    
    public Cliente obtCliente(int posicion){
        return clientes[posicion];
    }
    
    public Cliente[] obtClientes(){
        return clientes;
    }
}
