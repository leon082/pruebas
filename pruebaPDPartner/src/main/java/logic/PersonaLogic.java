/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.PersonaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Persona;

/**
 *
 * @author LuisLeon
 */
public class PersonaLogic {

    private PersonaDAO dao;

    public PersonaLogic() {
        dao = new PersonaDAO();
    }

    public boolean crearPersona(Persona persona) {
        if (persona != null) {

            try {
                return dao.crearPersona(persona);
            } catch (SQLException ex) {

                Logger.getLogger(PersonaLogic.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PersonaLogic.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            System.out.println("Persona Null");
            return false;
        }
    }

    public List<Persona> getAllPersona() {
        List<Persona> result = new ArrayList<>();
        try {
            result = dao.getAllPersonas();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonaLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public boolean editar(Persona persona) {

        if (persona != null) {
            try {
                dao.editarPersona(persona);
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(PersonaLogic.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PersonaLogic.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean eliminar(int id) {

        try {
            return dao.eliminarPersona(id);

        } catch (SQLException ex) {
            Logger.getLogger(PersonaLogic.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonaLogic.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
