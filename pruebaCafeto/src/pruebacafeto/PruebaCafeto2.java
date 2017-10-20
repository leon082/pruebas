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
public class PruebaCafeto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
/*The first line contains two space-separated integers denoting the respective values of  and . 
The second line contains two space-separated integers denoting the respective values of  and . 
The third line contains two space-separated integers denoting the respective values of  and . 
The fourth line contains  space-separated integers denoting the respective distances that each apple falls from point . 
The fifth line contains  space-separated integers denoting the respective distances that each orange falls from point 
         */

        Scanner in = new Scanner(System.in);
        //Rango de la casa
        int s = in.nextInt();
        int t = in.nextInt();

        //posicion de los arboles
        //Manzanas
        int a = in.nextInt();
        //naranjas
        int b = in.nextInt();

        //cantidad de manzanas y naranjas
        int m = in.nextInt();
        int n = in.nextInt();
        //distancia entre cada fruta con su arbol
        int[] apple = new int[m];
        for (int apple_i = 0; apple_i < m; apple_i++) {
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for (int orange_i = 0; orange_i < n; orange_i++) {
            orange[orange_i] = in.nextInt();
        }
         int manzanas = 0;
        
        for (int i = 0; i < apple.length; i++) {

            if ((a + apple[i] >= s) && (a + apple[i] <= t)) {
                manzanas++;
            }

        }
        int naranjas = 0;
        for (int i = 0; i < orange.length; i++) {

            if ((b + orange[i] >= s) && (b + orange[i] <= t)) {
                naranjas++;
            }

        }

        System.out.println(manzanas);
        System.out.println(naranjas);

    }

}
