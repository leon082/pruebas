/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pri.aleja.turnero;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author luis.leon
 */
public class Main {

    static List<Caja> cajas;
    static List<Turno> turnos;

    public static void main(String[] args) {

        int cantidadCajas = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite cantidad de Cajas Disponibles"));
        cajas = getCajas(cantidadCajas);

        int cantidadTurnos = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite cantidad de Turnos a Simular"));
        turnos = getTurnos(cantidadTurnos);
        
        gestionarTurnos();

    }

    public static List<Caja> getCajas(int cantidad) {

        List<Caja> list = new ArrayList<>();

        for (int i = 0; i < cantidad; i++) {
            Caja caja = new Caja();
            caja.setEstado(true);
            caja.setNombre("Caja numero " + (i+1));
            list.add(caja);
        }
        return list;

    }

    public static List<Turno> getTurnos(int cantidad) {

        List<Turno> list = new ArrayList<>();

        for (int i = 0; i < cantidad; i++) {
            Turno turno = new Turno();
            //solicitado=1
            turno.setEstado(1);
            turno.setDescripcion("Turno numero " + (i+1));
            turno.setComplejidad(i * 400);
            list.add(turno);
        }
        return list;

    }

    public static Turno obtenerCurrentTurno() {

        Turno result = new Turno();
        for (Turno objeto : turnos) {
            if (objeto.getEstado() == 1) {
                result = objeto;
                turnos.remove(objeto);
                break;
            }
        }
        return result;
    }
    
    public static void gestionarTurnos(){
        
        while (turnos.size()>0){
            
            for(int i=0; i < cajas.size();i++){
                
                cajas.get(i).setTurno(obtenerCurrentTurno());
                System.out.println("La caja "+cajas.get(i).getNombre()+
                        " Esta gestionando el turno "+cajas.get(i).getTurno().getDescripcion());
                cajas.get(i).start();
                
            }
            
        }
        
        
    }

  

}
