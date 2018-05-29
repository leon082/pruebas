/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import logic.PersonaLogic;
import model.Persona;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author LuisLeon
 */
@ViewScoped
@ManagedBean
public class PersonaBean {
    
    private Persona persona;
    private PersonaLogic logic;
    private List<Persona> listPersonas;
    private int ciudadSelected;
    
    @PostConstruct
    public void init() {
        persona = new Persona();
        logic = new PersonaLogic();
        listPersonas = new ArrayList<>();
        getAllPersonas();
    }
    
    public void crearPersona() {
        persona.setCiudad(ciudadSelected);
        if (logic.crearPersona(persona)) {
            getAllPersonas();
            limpiar();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Operacion realizado con exito");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "No se pudo realizar la oeración");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
        }
    }
    
    public void limpiar (){
        persona = new Persona();
    }
    
    public void getAllPersonas() {
        listPersonas = logic.getAllPersona();
    }
    
    public void modificar(RowEditEvent event) {
        
        Object ob = event.getObject();
        Persona pr = (Persona) ob;
        if (logic.editar(pr)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Operacion realizado con exito");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            getAllPersonas();
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "No se pudo realizar la operación");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
    }
    
    public void eliminar(int id) {
        
        if (logic.eliminar(id)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Operacion realizado con exito");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            getAllPersonas();
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "No se pudo realizar la operación");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
    }
    
    public Persona getPersona() {
        return persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public int getCiudadSelected() {
        return ciudadSelected;
    }
    
    public void setCiudadSelected(int ciudadSelected) {
        this.ciudadSelected = ciudadSelected;
    }
    
    public List<Persona> getListPersonas() {
        return listPersonas;
    }
    
    public void setListPersonas(List<Persona> listPersonas) {
        this.listPersonas = listPersonas;
    }
    
}
