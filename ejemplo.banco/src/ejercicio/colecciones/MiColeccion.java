/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author luis.leon
 */
public class MiColeccion {

    List<Integer> numeros;

    public MiColeccion() {
        this.numeros = new ArrayList<>();
    }

    public void insertarAlFinal(int valor) {
        numeros.add(valor);
    }

    public void insertarAlPrincipio(int valor) {
        numeros.add(0, valor);
    }

    public void agregarAlFinal(List<Integer> valor) {
        numeros.addAll(valor);
    }

    public void eliminar(int posicion) {
        numeros.remove(posicion);
    }

    public void setValor(int posicion, int valor) {
        numeros.add(posicion, valor);
    }

    public int getValor(int posicion) {
        return numeros.get(posicion);
    }

    public int getSumatoria() {
        int total = 0;
        for (int valor : numeros) {
            total += valor;
        }
        return total;
    }

    public double getPromedio() {
        int total = 0;
        for (int valor : numeros) {
            total += valor;
        }
        return (double) total / numeros.size();
    }

    public int cuentaElementos() {
        return numeros.size();
    }

    public int cuentaCeros() {
        int total = 0;
        for (int valor : numeros) {
            if (valor == 0) {
                total++;
            }
        }
        return total;
    }

    public int sumaPares() {
        int total = 0;
        for (int valor : numeros) {
            if (valor % 2 == 0) {
                total += valor;
            }
        }
        return total;
    }

    public int cuentaRepeticiones(int numero) {
        int total = 0;
        for (int valor : numeros) {
            if (valor == numero) {
                total++;
            }
        }
        return total;
    }

    public void reemplazarValor(int antiguoValor, int nuevoValor) {
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) == antiguoValor) {
                numeros.set(i, nuevoValor);
            }
        }
    }

    public void reemplazarTodo(List<Integer> a) {
        numeros = new ArrayList<>(a);

    }

    public List<Integer> invertir() {
        List<Integer> result = new ArrayList<>(numeros);
        Collections.reverse(result);
        return result;
    }

    public int getMayor() {
        int mayor = 0;
        for (int valor : numeros) {

            if (mayor == 0) {
                mayor = valor;
            }

            if (valor > mayor) {
                mayor = valor;
            }

        }
        return mayor;

    }

    public int getMenor() {
        int menor = 0;
        for (int valor : numeros) {

            if (menor == 0) {
                menor = valor;
            }

            if (valor < menor) {
                menor = valor;
            }

        }
        return menor;

    }

    public List<Integer> getPrimeros(int cantidad) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < cantidad; i++) {
            result.add(numeros.get(i));
        }

        return result;
    }

    public List<Integer> getUltimos(int cantidad) {

        List<Integer> result = new ArrayList<>();
        int contador = 0;
        int i = numeros.size() - 1;

        while (contador < cantidad) {
            result.add(numeros.get(i - contador));

            contador++;
        }
        Collections.reverse(result);
        return result;
    }

    public boolean esPalindrome() {
        
        List<Integer> contraria = new ArrayList<>(numeros);
        Collections.reverse(contraria);
        
        for (int i=0; i<contraria.size();i++){
            if(contraria.get(i).intValue() != numeros.get(i).intValue()) {
                return false;
            }
        }

        return true;
    }

    public boolean buscar(int numero) {

        for (int valor : numeros) {
            if (valor == numero) {
                return true;
            }
        }
        return false;
    }

    public void mostrarContenido() {

        System.out.println(numeros);
    }

}
