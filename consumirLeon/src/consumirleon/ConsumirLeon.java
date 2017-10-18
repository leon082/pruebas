/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumirleon;

import consumir.suma.Hello;
import consumir.suma.Suma;
import consumir.suma.Sumar;
import consumir.suma.Sumar_Service;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon
 */
public class ConsumirLeon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sumar_Service servicio = new Sumar_Service();
        Sumar webservice = servicio.getSumarPort();
        int result=webservice.suma(1, 2);
        System.out.println("Resultad:" + result);
        JOptionPane.showMessageDialog(null,webservice.hello("Leon y Lizeth !!!!!... \n Tu novio es un genio asi de sencillo!!!!!"));
        
        
        
    }
    
}
