/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos.listasenlazadas;

import com.sun.xml.internal.ws.developer.UsesJAXBContext;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import javafx.scene.Node;
import test.use.interfaces.IPrueba;

/**
 *
 * @author luis.leon
 */
public class Pruebas {
    
    
    public IPrueba prueba;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
       // int a = Integer.parseInt("12");
        /*String valor = "null";
        if ((!valor.trim().equalsIgnoreCase("ABIERTO"))) {
            System.out.println("Dia actual.. " + findAndReplace(""));

        }*/
             /*System.out.println("Cantidad de Registros: " + 4 + "\n"
                    + "Numeros Positivos: " + 5 + "\n"
                    + "Numeros Negativos: " + 6 );
            String sql= " SELECT E.*\n" +
                        " FROM EMPRESA E\n" +
                        " LEFT OUTER JOIN\n" +
                        " ORDENEMPRESA OC\n" +
                        " ON E.ID  =OC.EMPRESA\n" +
                        " WHERE E.ESTADO=:ESTADO\n" +
                        " ORDER BY OC.ORDENEMPRESA";
            System.out.println(sql);
            System.out.println("REsulttado"+2*3*4);
            List<String>  list= getEnter();
            //System.out.println(list.get(0));*/
             //init();
         
         /*   

        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);*/
    }
    /*
    public Node Reverse(Node head) {
        Node prev;
        Node current= head;
        Node next;
        while(current != null){
            
            next=current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
   
    }
    */
    
        static String kangaroo(int x1, int v1, int x2, int v2) {
             // Complete this function
             boolean flag=true;
             String respuesta="default";
             
             
            do {  
                if((x2>x1 && v2>v1) 
                        || (x1>x2 && v1>v2)
                        || (v1==v2)){
                    flag=false;
                    respuesta="NO";
                }else{
                      x1+=v1;
                      x2+=v2;
                      if(x1==x2){
                          flag=false;
                          respuesta="YES";
                      }
               
                }
              
                
                
            } while (flag);
            
            return respuesta;
             
    }
    public static void init(){
        //System.out.println(prueba.saludo());
    }

    public static BigInteger findAndReplace(final String holyDay) {
        Date fecha = new Date();
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(fecha);
        BigInteger dia = BigInteger.valueOf(cal.get(Calendar.DAY_OF_WEEK));
        //System.out.println(dia.toString());
        //Fin de Semana
        if (dia.toString().equalsIgnoreCase("1") || dia.toString().equalsIgnoreCase("7")) {

            return BigInteger.valueOf(1);

        } else {
            //Dia Festivo
            SimpleDateFormat d = new SimpleDateFormat("yyyy/MM/dd");
            String strDate = d.format(fecha);
            String[] diasFestivos = holyDay.split(",");
            for (int i = 0; i < diasFestivos.length; i++) {
                if (diasFestivos[i].equalsIgnoreCase(strDate)) {
                    return BigInteger.valueOf(1);

                }
            }

        }

        return BigInteger.valueOf(0);
    }
    
    public static List<String> getEnter(){
        return Collections.EMPTY_LIST;
    }

}
