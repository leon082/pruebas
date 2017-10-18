/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos.arboles;

/**
 *
 * @author luis.leon
 */
public class BST {

    Nodo raiz;
    
    public BST(){
        this.raiz=null;
    }
    
    public void insertar(int key, Object valor){
        
        Nodo n = new Nodo(key);
        n.valor=valor;
        
        if(raiz == null){
            raiz=n;
        }else{
            Nodo temporal = raiz;
            while(temporal!=null)
            {
                n.p=temporal;
                if(n.key>=temporal.key){
                    temporal= temporal.der;
                }else{
                    temporal = temporal.izq;
                }
                
            }
            if(n.key < n.p.key){
                n.p.izq=n;
            }else{
                n.p.der=n;
            }
        }
    }
    
    public void inOrden(Nodo x){
        if(x!= null){
            inOrden(x.izq);
            System.out.println(x.key);
            inOrden(x.der);
        }
    }
    public class Nodo {

        public Nodo p; //padre
        public Nodo der;
        public Nodo izq;
        public int key;
        public Object valor;

        public Nodo(int key) {
            this.key = key;
            der = null;
            izq = null;
            p = null;
            valor = null;
        }
    }

}
