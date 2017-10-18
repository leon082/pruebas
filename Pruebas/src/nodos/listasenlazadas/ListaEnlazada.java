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
public class ListaEnlazada {

    Nodo cabeza;
    int size;

    public ListaEnlazada() {
        this.cabeza = null;
        this.size = 0;
    }

    public void addFirst(Object obj) {
        if (cabeza == null) {
            cabeza = new Nodo(obj);
        } else {
            Nodo temp = cabeza;
            Nodo nuevo = new Nodo(obj);
            nuevo.putNext(temp);
            cabeza = nuevo;
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    public Object get(int index) {
        int count = 0;
        Nodo temp = cabeza;
        while (count < index) {

            temp = temp.getNext();
            count++;
        }
        return temp.getValor();
    }

    public boolean isempty() {
        return (cabeza == null) ? true : false;
    }

    public void deleteFirst() {
        cabeza = cabeza.getNext();
        size--;
    }

    public void delete(int index) {
        if (index == 0) {
            cabeza = cabeza.getNext();
        } else {

            int count = 0;
            Nodo temp = cabeza;
            while (count < index - 1) {

                temp = temp.getNext();
                count++;
            }
            temp.putNext(
                    temp.getNext().getNext());

        }
        size--;
    }
    
    public void cut(int index){
        
         int count = 0;
            Nodo temp = cabeza;
            while (count < index - 1) {
                temp= temp.getNext();
                count++;
            }
            temp.putNext(null);
            
            size=index;
    }
}
