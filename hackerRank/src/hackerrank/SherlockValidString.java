/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author luis.leon
 */
public class SherlockValidString {

    /// Complete the isValid function below.
    static String isValid(String s) {
        if (s.length() < 2) {
            return "YES";
        } else {
            return validate(s, 0, s.substring(0, 1), 0)
                    ? "YES"
                    : "NO";
        }
    }

    static boolean validate(String s, int promedio, String caracter, int saltos) {

        int cantidadveces = calculateTimes(s, caracter);
        s = s.replaceAll(caracter, "");
        System.out.println(saltos);
        if (promedio != 0) {

            if (cantidadveces - promedio != 0) {

                saltos = saltos + (cantidadveces - promedio);
            }

            if ((saltos == 1 || saltos == 0) && s.length() > 0) {

                return validate(s, promedio, s.substring(0, 1), saltos);

            } else {

                return saltos < 2 && s.length() == 0;
            }
        } else {

            promedio = cantidadveces;
            return validate(s, promedio, s.substring(0, 1), saltos);
        }

    }

    static int calculateTimes(String s, String caracter) {
        int posicion, contador = 0;
        //se busca la primera vez que aparece
        posicion = s.indexOf(caracter);
        while (posicion != -1) { //mientras se encuentre el caracter
            contador++;           //se cuenta
            //se sigue buscando a partir de la posición siguiente a la encontrada
            posicion = s.indexOf(caracter, posicion + 1);
        }
        return contador;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);
        System.out.println("resultado " + result);

        /*bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();*/
        scanner.close();

        int a = 4, b = 5;
        System.out.println("before--> a= " + a + " b= " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("after--> a= " + a + " b= " + b);

        String a1 = "a", b1 = "b";
    }
}
