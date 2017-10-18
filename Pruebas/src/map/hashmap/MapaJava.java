/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author luis.leon
 */
public class MapaJava {

    public static void main(String[] args) {
        HashMap<String, String> lista = new HashMap<>();
        lista.put("Leon", "222222");
        lista.put("Pedro", "555555");
        lista.put("hj", "666666");
        lista.put("Taxi", "11111");
        lista.put("Marcela", "999999");
        //tamaño
        //lista.size();
        //obtener el valor por medio de la clave
        // String telefono= lista.get("Leon");
        // System.out.println(telefono);

        //lista.remove("Carlos");
        for (Map.Entry m : lista.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

    }

}
