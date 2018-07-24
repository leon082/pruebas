/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.banco;

import modelo.Banco;
import modelo.Cliente;
import modelo.Empresa;
import modelo.Persona;

/**
 *
 * @author luis.leon
 */
public class EjemploBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //inicializo 10 clientes , 5 empresas y 5 personas        
        Banco banco = new Banco("Bancolombia");
        for (int i = 0; i < 10; i++) {
             Cliente obj;
            if (i <= 5) {
               obj  = new Empresa("" + i, "Empresa " + i, "Representante " + i);
                banco.adCliente(obj);
            } else {
                obj = new Persona("" + i, "Persona " + i, i);
                banco.adCliente(obj);
            }
        }

        //Punto a
        System.out.println("Se imprime punto a -->");
        for (int i = 0; i < banco.obtNumClientes(); i++) {

            System.out.println("Nombre -> " + banco.obtCliente(i).obtNombre());

        }

        //Punto b
        System.out.println("Se imprime punto b -->");
        for (int i = 0; i < banco.obtNumClientes(); i++) {
            
            if (banco.obtCliente(i) instanceof Persona) {
                System.out.println("Nombre -> " + banco.obtCliente(i).obtNombre());
                System.out.println("Cedula -> " + banco.obtCliente(i).obtIdentificacion());
            }

        }
        
         //Punto c
        System.out.println("Se imprime punto c -->");
        for (int i = 0; i < banco.obtNumClientes(); i++) {
            
            if (banco.obtCliente(i) instanceof Empresa) {
                Empresa obj = (Empresa) banco.obtCliente(i);
                System.out.println("Nombre -> " + obj.obtNombre());
                System.out.println("Representante -> " + obj.obtRepresentante());
            }

        }
        
        
        //Punto d
        System.out.println("Se imprime punto d -->");
        for (int i = 0; i < banco.obtNumClientes(); i++) {
            
            if (banco.obtCliente(i) instanceof Persona) {
                Persona obj = (Persona) banco.obtCliente(i);
                if(Integer.valueOf(obj.obtEdad())<18){
                System.out.println("Nombre -> " + obj.obtNombre());
                System.out.println("Edad (Menor de edad) -> " + obj.obtEdad());
                }
            }

        }
        
         //Punto e
        System.out.println("Se imprime punto e -->");
        int edadMasJoven=0;
        String nombreJoven="";
        
        for (int i = 0; i < banco.obtNumClientes(); i++) {
            
            if (banco.obtCliente(i) instanceof Persona) {
                Persona obj = (Persona) banco.obtCliente(i);
                if(edadMasJoven==0 && "".equalsIgnoreCase(nombreJoven)){
                    edadMasJoven = Integer.valueOf(obj.obtEdad());
                    nombreJoven=obj.obtNombre();
                }
                if(Integer.valueOf(obj.obtEdad()) < edadMasJoven){
                    edadMasJoven = Integer.valueOf(obj.obtEdad());
                    nombreJoven=obj.obtNombre();                    
                }
            }

        }
        
        System.out.println("Cliente mas Joven ");
        System.out.println("nombre -> "+nombreJoven);
        System.out.println("edad -> "+edadMasJoven);
        
        
        
        //Punto f
        System.out.println("Se imprime punto f -->");
        int edadMasViejo=0;
        String nombreViejo="";
        
        for (int i = 0; i < banco.obtNumClientes(); i++) {
            
            if (banco.obtCliente(i) instanceof Persona) {
                Persona obj = (Persona) banco.obtCliente(i);
                if(edadMasViejo==0 && "".equalsIgnoreCase(nombreViejo)){
                    edadMasViejo = Integer.valueOf(obj.obtEdad());
                    nombreViejo=obj.obtNombre();
                }
                if(Integer.valueOf(obj.obtEdad()) > edadMasViejo){
                    edadMasViejo = Integer.valueOf(obj.obtEdad());
                    nombreViejo=obj.obtNombre();                    
                }
            }

        }
        
        System.out.println("Cliente mas Viejo ");
        System.out.println("nombre -> "+nombreViejo);
        System.out.println("edad -> "+edadMasViejo);
        
        

    }

}
