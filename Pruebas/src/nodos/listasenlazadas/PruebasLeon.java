/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos.listasenlazadas;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
      
      /*
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
      
      List<String> list = new ArrayList<String>();
      list.add("a");
      list.add("b");
      list.add("c");*/
      
     
     
      try {
			String password = generateHash("alex12345");
			String linea ="";
			Scanner in = new Scanner(System.in);
			System.out.print("Ingresa clave:");
			while(!linea.equals("x")) {
				linea = in.next();
				if(password.equals(generateHash(linea))) {
					System.out.println("Clave correcta" + generateHash(linea));
				}
				else {
					System.err.println("Clave fallida");
				}
			}
			System.out.println("Finalizar");
		} catch (NoSuchAlgorithmException | RuntimeException e) {
			e.printStackTrace();
		}
      
      
             
    }
    
     public static String generateHash(String password) throws RuntimeException, NoSuchAlgorithmException{

		if (password.length() < 0) {
			System.err.println("String to MD5 digest should be first and only parameter");
			throw new RuntimeException();
		}
		String original = password;
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(original.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}

		return sb.toString();
	}

 

}
