/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos.arboles;

import nodos.listasenlazadas.*;
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
public class ArbolesMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      BST arbol = new BST();
      
      arbol.insertar(20, null);
      arbol.insertar(2, null);
      arbol.insertar(3, null);
      arbol.insertar(4, null);
      arbol.insertar(6, null);
      arbol.insertar(8, null);
      arbol.insertar(10, null);
      
      arbol.inOrden(arbol.raiz.izq);
             
    }

 

}
