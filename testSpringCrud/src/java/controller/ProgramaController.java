/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ProgramaDao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
import entity.TbPrograma;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author luis.leon
 */
@Controller
public class ProgramaController {

    @RequestMapping("index")
    public ModelAndView redireccio() {
        ModelAndView MV = new ModelAndView();
        MV.setView("index");
        return MV;
    }

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public String getAll(Model m) {

        ProgramaDao dao = new ProgramaDao();
        Model addAttribute = m.addAttribute("list", dao.getAll());
        //Retorna el nombre de la pagina q voy a cargar
        return "programasView";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "id") int id, Model m) {

        java.math.BigDecimal bd = new java.math.BigDecimal(String.valueOf(id));
        ProgramaDao dao = new ProgramaDao();
        TbPrograma programa = new TbPrograma();
        programa = dao.getProgramaById(bd);
        m.addAttribute("programa", programa);

        //Retorna el nombre de la apgina q voy a retornar
        return "edit";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute(value = "programa") TbPrograma programa) {

        ProgramaDao dao = new ProgramaDao();
        TbPrograma aux = new TbPrograma();
        aux = dao.getProgramaById(programa.getIdPrograma());

        aux.setDescripcion(programa.getDescripcion());
        aux.setEstado(programa.isEstado());
        aux.setCreadopor(programa.getCreadopor());
        aux.setCreadoen(programa.getCreadoen());
        aux.setModificadopor(programa.getModificadopor());
        aux.setModificadoen(programa.getModificadoen());

        dao.update(aux);
        return "redirect:getAll.html";

    }

}
