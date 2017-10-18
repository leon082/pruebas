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
public class pruebaJeison {

    public static void main(String[] args) {

        //punto 1
        tablaTuplas("5,6,-6,3,-4,5,0,9,5,4,0,5,8,7,0");
        //punto2
        informePrestamos(5000000, Double.valueOf(0.2), 2);

    }

    public static void informePrestamos(int monto, double tasa, int numCuotas) {
        //Varaibles fijas
        double capitalAPagar = (monto / numCuotas);
        //Se calcula todo para el primer mes
        double montoAdeudado = monto;
        double interesAPagar = (tasa * montoAdeudado);
        double valorCuota = capitalAPagar + interesAPagar;

        for (int i = 1; i <= numCuotas; i++) {

            System.out.println("Numero de Cuota: " + i + "\n"
                    + "Monto Adeudado: " + montoAdeudado + "\n"
                    + "Valor de la Cuota: " + valorCuota + "\n"
                    + "Interes de la Cuota: " + interesAPagar + "\n"
                    + "Capital a Pagar: " + capitalAPagar);
            //Se calculo todo para el siguiente mes
            montoAdeudado = montoAdeudado - capitalAPagar;
            interesAPagar = (tasa * montoAdeudado);
            valorCuota = capitalAPagar + interesAPagar;

        }

    }

    public static void tablaTuplas(String cadena) {

        int numerosPositivos = 0;
        int numerosNegativos = 0;
        String[] vectorCadena = cadena.split(",");
        int totalRegistros = vectorCadena.length;

        for (int i = 0; i < totalRegistros; i++) {
            if (Integer.valueOf(vectorCadena[i]) > 0) {
                numerosPositivos++;
            }
            if (Integer.valueOf(vectorCadena[i]) < 0) {
                numerosNegativos++;
            }

        }
        System.out.println("Cantidad de Registros: " + totalRegistros + "\n"
                + "Numeros Positivos: " + numerosPositivos + "\n"
                + "Numeros Negativos: " + numerosNegativos);

    }

}
