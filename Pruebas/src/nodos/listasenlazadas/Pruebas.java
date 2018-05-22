/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos.listasenlazadas;

import com.sun.xml.internal.ws.developer.UsesJAXBContext;
import java.io.BufferedReader;
import java.io.FileReader;
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
        System.out.println(result);
          Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        
        String[] cadenas = new String[n];
       
        for(int i=0; i<n;i++){
            
            cadenas[i]=in.nextLine();
        }
       
               int m = Integer.valueOf(in.nextLine());
         String[] queries = new String[m];
        
        for(int i=0; i<m;i++){
            queries[i]=in.nextLine();
        }
        int contador=0;
        for(int i=0; i< queries.length;i++){
            for(int j=0; j< cadenas.length;j++){
                    
                if(queries[i].equalsIgnoreCase(cadenas[j])){
                    contador++;
                }
                    
                
            }
            System.out.println(contador);
            contador=0;
        }
        
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
   /*Node InsertNth(Node head, int data, int position) {
   // This is a "method-only" submission. 
    // You only need to complete this method. 
    Node prev;
        Node current= head;
        Node element= new Node(data,null);
        Node temp;
        int index=0;
        while(current != null ){
            
            temp=current;
            current = current.next;           
            prev = temp;
                 if(index == position){
                      prev.next=element;
                      element.next=current;
                      break;
            
            }
            index++;
            
        }
        
        return head;
    
}
   
  Scanner in = new Scanner(System.in);
        double meal_cost = in.nextDouble();
        int tip_percent = in.nextInt();
        int tax_percent = in.nextInt();
        in.close();
        double tip = meal_cost*( (float) tip_percent/100);
       
        double tax = meal_cost*((float) tax_percent/100);
        System.out.println(tax);
        double total= meal_cost+tip+tax;
        System.out.println(total);
        int imprimir= (int) Math.round (total);
        System.out.println("The total meal cost is "+imprimir+" dollars.");*/
   /*
   int a=5;
   int b=2;
   
   
   a= a+b;   
   b= a-b;   
   a=a-b;
   
   System.out.println("Valor de A= "+a);
   System.out.println("Valor de B= "+b);*/
   
   /* Calendar cal= Calendar.getInstance();
               String cal_for_month = (cal.get(Calendar.MONTH)+"").length() == 1 ?("0"+cal.get(Calendar.MONTH)+""):(cal.get(Calendar.MONTH)+"");
               String cal_for_year = cal.get(Calendar.YEAR)+"";
                String cal_for_day =(cal.get(Calendar.DAY_OF_MONTH)+"").length() == 1 ?("0"+cal.get(Calendar.DAY_OF_MONTH)):(cal.get(Calendar.DAY_OF_MONTH)+""); 
                long result= Long.parseLong(cal_for_day+cal_for_month+cal_for_year);
                System.out.println("REsultado-> "+result);*/
   /*String error ="Error en Descargue y Amarre de Chequera: Error. ";
   error += "Error en Nota Debito: Error nota. ";
   Long.parseLong("395920.0");
   System.out.println(error);*/
    /*String valorTemp="39424.0";
                double debitoTemp = Double.parseDouble(valorTemp.replaceAll(",", ""));
               long valorDebito = (new Double(debitoTemp).longValue());
               */
    
              // System.out.println("Valor "+Long.parseLong("395920"));
              String valor = "s ,s ,s ";
              String [] pila= valor.split(",");
              
              System.out.println(pila[0].trim());
   
   
   
   
    }
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
