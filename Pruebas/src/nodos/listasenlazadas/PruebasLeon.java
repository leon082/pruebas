/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos.listasenlazadas;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author luis.leon
 */
public class PruebasLeon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      /*
        Nodo primer = new Nodo("Ejemplo");
        Nodo segundo = new Nodo(45);
        Nodo tercero = new Nodo("Hola");
        
        primer.putNext(segundo);
        primer.getNext().putNext(tercero);
        
        System.out.println(primer
                //.getNext()
                .getNext().getValor());*/
      ListaEnlazada lista= new ListaEnlazada();
      System.out.println("Esta Vacia: "+lista.isempty());
      
      lista.addFirst("Leon");
      lista.addFirst(20);
      lista.addFirst("Hola que tal");
      lista.addFirst(30);
      
       System.out.println("Primer Elemento: " + lista.get(0));
       System.out.println("Ultimo: " + lista.get(lista.getSize()-1));
       System.out.println("Index 2: " + lista.get(2));
       
       System.out.println("Esta Vacia: "+lista.isempty());
       System.out.println("Tamaño: "+lista.getSize());
      
      lista.delete(2);
      System.out.println("Index 2: " + lista.get(2));
      
      lista.cut(3);
      System.out.println("Index 2: " + lista.cabeza.valor);
             
    }

 

}
