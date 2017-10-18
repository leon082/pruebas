/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos.listasenlazadas;

/**
 *
 * @author luis.leon
 */
public class Nodo {
    
    Object valor;
    Nodo siguiente;

    public Nodo(Object valor) {
        this.valor = valor;
        this.siguiente=null;
    }
    
    public Object getValor(){
        return valor;
    }
    
    public void putNext(Nodo n){
        this.siguiente=n;
    }
    
    public Nodo getNext(){
        return siguiente;
    }
    
}
