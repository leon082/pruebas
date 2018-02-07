/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.TbPrograma;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author luis.leon
 */
public class ProgramaDao {

    //CRUD
    public List<TbPrograma> getAll() {
        List<TbPrograma> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            s.beginTransaction();
            list = s.createCriteria(TbPrograma.class).list();
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        }

        return list;
    }

    //Create
    public void create(TbPrograma programa) {
        List<TbPrograma> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            s.beginTransaction();
            s.save(programa);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        }

    }

    //Remove
    public void remove(TbPrograma programa) {
        List<TbPrograma> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            s.beginTransaction();
            s.delete(programa);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        }

    }
    
    //Update
    public void update(TbPrograma programa) {
        List<TbPrograma> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            s.beginTransaction();
            s.update(programa);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        }

    }
    
     //getById
    public TbPrograma getProgramaById(BigDecimal id) {
        TbPrograma programa = new TbPrograma();
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            s.beginTransaction();
           programa= (TbPrograma) s.get(TbPrograma.class, id);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        }
        return programa;

    }
    /*
     //getById
    public TbPrograma getProgramaByservicio(BigDecimal id) {
        TbPrograma programa = new TbPrograma();
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            s.beginTransaction();
            s.createQuery("");
            
           programa= (TbPrograma) s.get(TbPrograma.class, id);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        }
        return programa;

    }*/
    
   

}
