/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebacafeto;

import java.util.Scanner;

/**
 *
 * @author LuisLeon
 */
public class PruebaCafeto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        String caracter = "#";

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 1;
        String space = "";
        int spaces = n - 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < spaces; j++) {
                space += " ";
            }
            System.out.println(space + caracter);
            caracter += (char)35;
            spaces--;
            space = "";
            
            
        }

    }

}
