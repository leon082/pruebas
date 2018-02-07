/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Departamento;
import entity.Profesor;
import model.DepartamentoModel;
import model.ProfesorModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DanielEduardo
 */
@Controller
public class DepartamentoController {
    
    @RequestMapping(value="getAlldp",method = RequestMethod.GET)
    public String getAlldp(Model m)
    {
        
        DepartamentoModel model= new DepartamentoModel();
        m.addAttribute("lst",model.getAll());
        return "datadp";
    }
    
    @RequestMapping(value="editdp",method = RequestMethod.GET)
    public String editdp(@RequestParam(value="id") int id,Model m)
    {
        java.math.BigDecimal bd=new java.math.BigDecimal(String.valueOf(id));
        DepartamentoModel model= new DepartamentoModel();
       
       
        Departamento dp=new Departamento();
        DepartamentoModel dpModel= new DepartamentoModel();
        dp=model.getDepartamento(bd);
     
        m.addAttribute("dp", dp);
     
        
        return "editdp";
    }
    
    @RequestMapping(value = "updatedp",method=RequestMethod.POST)
    public String updatedp(@ModelAttribute(value="Departamento") Departamento dp)
    {
        
        
       DepartamentoModel model= new DepartamentoModel();
       DepartamentoModel dpmodel=new DepartamentoModel();
       //Departamento dp=new Departamento();
       Departamento  aux= new Departamento();
   
        
        
      
        aux=model.getDepartamento(dp.getId());
        aux.setNombre(dp.getNombre());
       
        // aux.setDepartamento(dp);
        model.edit(aux);
        return "redirect:getAlldp.html";
    }
    
    //remover
     @RequestMapping(value = "removedp", method = RequestMethod.GET)
    public String removedp(@RequestParam(value = "id") int id, Model m) {

        java.math.BigDecimal bd = new java.math.BigDecimal(String.valueOf(id));
       DepartamentoModel model = new DepartamentoModel();
        //get EMpleados bases objct id        m.addAttribute("lst",model.getAll());
       Departamento e = new Departamento();
        e = model.getDepartamento(bd);
        model.remove(e);
               // m.addAttribute("lst",e);       

        return "redirect:getAlldp.html";
    }
    
    
    //create
    
     @RequestMapping(value="creardp",method = RequestMethod.GET)
    public String createdp(Model m)
    {
      //  java.math.BigDecimal bd=new java.math.BigDecimal(String.valueOf(id));
        ProfesorModel model= new ProfesorModel();
        Departamento dp =new Departamento();
        
                
        m.addAttribute("dp",dp);
               
        return "creardp";
    }
    
    
    
    @RequestMapping(value = "adddp",method=RequestMethod.POST)
    public String createdp(@ModelAttribute(value="Departamento") Departamento p)
    {
        
        Departamento dp=new Departamento();
        DepartamentoModel dpm=new DepartamentoModel();
        
        
        dp=dpm.getDepartamento(p.getId());
        dp.setId(p.getId());
        dp.setNombre(p.getNombre());
        //p.setId(p.getId());
       // p.setDepartamento(dp);
        ProfesorModel model=new ProfesorModel();
        dpm.create(dp);
        return "redirect:getAlldp.html";
    }
    

    
    
    
    
    }
