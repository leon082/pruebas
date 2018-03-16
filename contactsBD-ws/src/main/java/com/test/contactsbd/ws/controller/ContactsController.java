/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.contactsbd.ws.controller;

import com.test.contactsbd.ws.model.LL_Contact;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luis.leon
 */
@RequestMapping("/contacts")
@RestController
public class ContactsController {
    
    
     
    @RequestMapping(value = "/")
    public ResponseEntity<Map<String, LL_Contact>> getAllContacts() {        
       // Map<String, LL_Contact> map = notes.getContacts();
       // ResponseEntity<Map<String, LL_Contact>> response = new ResponseEntity<>(map, HttpStatus.OK);
        return null;
    }
    
    @RequestMapping(value = "/getContactByID/{id}", method = RequestMethod.GET)
    public ResponseEntity<LL_Contact> getContact(@PathVariable String id) {
        //ResponseEntity<Contact> response = new ResponseEntity<>(notes.get(id), HttpStatus.OK);
        return null;
    }
    
    @RequestMapping(value = "/saveContact", method = RequestMethod.POST)
    public String addContact(@RequestBody LL_Contact contact) {
        
        return"";
                //("Guardado el contacto " +notes.save(contact.getFirstName(), contact));
        
    }
    /*
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<Contact> updateContact() {
        LL_Contact contact = new LL_Contact(1L, "Maria", "Perea", "315-897452", "correo@gmail.com");
        ResponseEntity<Contact> response = new ResponseEntity<Contact>(contact, HttpStatus.OK);
        return response;
    }*/
    
    @RequestMapping(value = "/deleteContact/{id}", method = RequestMethod.DELETE)
    public String deleteContact(@PathVariable String name) {
        
        //notes.remove(name);
        return "Eliminado el contacto "+name;
    }
    
}
