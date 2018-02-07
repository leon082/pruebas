/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Departamento;
import entity.Profesor;
import java.math.BigDecimal;
import model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author DanielEduardo
 */

@Controller
public class ProfesorController {
    
    @RequestMapping("index")
    public ModelAndView redireccio()
    {
        
        ModelAndView MV= new ModelAndView();
        MV.setView("index");
   //     MV.addObject("mensaje","Hola soy un mensaje desde copntrolador");
        
        return MV;
    }
    
    
    @RequestMapping(value="getAll",method = RequestMethod.GET)
    public String getAll(Model m)
    {
        
        ProfesorModel model= new ProfesorModel();
        m.addAttribute("lst",model.getAll());
        return "data";
    }
    
    @RequestMapping(value="edit",method = RequestMethod.GET)
    public String edit(@RequestParam(value="id") int id,Model m)
    {
        java.math.BigDecimal bd=new java.math.BigDecimal(String.valueOf(id));
        ProfesorModel model= new ProfesorModel();
       
        Profesor p =new Profesor();
        Departamento dp=new Departamento();
        DepartamentoModel dpModel= new DepartamentoModel();
        p=model.getProfesor(bd);
        dp=dpModel.getDepartamento(p.getDepartamento().getId());
        
        m.addAttribute("p",p);
        //m.addAttribute("d", dp);
      //  m.addAttribute("d",p.getDepartamento());
        
        return "edit";
    }
    
    @RequestMapping(value = "update",method=RequestMethod.POST)
    public String update(@ModelAttribute(value="Profesor") Profesor p)
    {
        
        
       ProfesorModel model= new ProfesorModel();
       DepartamentoModel dpmodel=new DepartamentoModel();
       Departamento dp=new Departamento();
       Profesor aux= new Profesor();
        aux=model.getProfesor(p.getId());
        aux.setNombre(p.getNombre());
        aux.setCorreo(p.getCorreo());
        aux.setTelefono(p.getTelefono());
        aux.setNacimiento(p.getNacimiento());
        aux.setDireccion(p.getDireccion());
           // aux.setDepartamento(dp);
        model.edit(aux);
        return "redirect:getAll.html";
    }

    //remover
    
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String remove(@RequestParam(value = "id") int id, Model m) {

        java.math.BigDecimal bd = new java.math.BigDecimal(String.valueOf(id));
        ProfesorModel model = new ProfesorModel();
        Profesor e = new Profesor();
        e = model.getProfesor(bd);
        model.remove(e);
                    

        return "redirect:getAll.html";
    }
    
    
     @RequestMapping(value="crear",method = RequestMethod.GET)
    public String create(Model m)
    {
      //  java.math.BigDecimal bd=new java.math.BigDecimal(String.valueOf(id));
        ProfesorModel model= new ProfesorModel();
        Profesor p =new Profesor();
        
                
        m.addAttribute("p",p);
               
        return "create";
    }
    
    
    
    @RequestMapping(value = "add",method=RequestMethod.POST)
    public String create(@ModelAttribute(value="Profesor") Profesor p)
    {
        
        Departamento dp=new Departamento();
        DepartamentoModel dpm=new DepartamentoModel();
        
        
        dp=dpm.getDepartamento(BigDecimal.ONE);
        p.setId(p.getId());
        p.setDepartamento(dp);
        ProfesorModel model=new ProfesorModel();
        model.create(p);
        return "redirect:getAll.html";
    }
   
 
}
