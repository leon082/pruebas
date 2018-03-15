/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.contacts.ws.noteBook;

import com.test.contacts.ws.model.Contact;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;


/**
 *
 * @author luis.leon
 */

@Singleton
public class NoteBook {
    
    private  Map<String, Contact> contacts = new HashMap<>();
    
    @PostConstruct
    public void init(){
        this.contacts = new HashMap<>();
        
    }
    
    public String save(String name, Contact contact){
       
        contacts.put(name,contact);
        return name;
    }
    
   
    public Contact get(String name){
        return contacts.get(name);
    }
    
    public List<Contact> list(){
        List<Contact> list = (List)contacts.values();
        return list;
                
               
    }
    
    public void remove(String id){
        contacts.remove(id);
    }
}
