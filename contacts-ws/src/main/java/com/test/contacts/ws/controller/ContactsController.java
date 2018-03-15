/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.contacts.ws.controller;

import com.test.contacts.ws.model.Contact;
import com.test.contacts.ws.noteBook.NoteBook;
import java.util.List;
import javax.annotation.PostConstruct;
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
    
    private NoteBook notes;
    
    @PostConstruct()
    public void init() {
        notes = new NoteBook();
    }
    
    @RequestMapping()
    public ResponseEntity<List<Contact>> getAllContacts() {        
        ResponseEntity<List<Contact>> response = new ResponseEntity<>(notes.list(), HttpStatus.OK);
        return response;
    }
    
    @RequestMapping(value = "/getContactByID/{id}", method = RequestMethod.GET)
    public ResponseEntity<Contact> getContact(@PathVariable String id) {
        ResponseEntity<Contact> response = new ResponseEntity<>(notes.get(id), HttpStatus.OK);
        return response;
    }
    
    @RequestMapping(value = "/saveContact", method = RequestMethod.POST)
    public String addContact(@RequestBody Contact contact) {
        
        return ("Guardado el contacto " +notes.save(contact.getFirstName(), contact));
        
    }
    /*
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<Contact> updateContact() {
        Contact contact = new Contact(1L, "Maria", "Perea", "315-897452", "correo@gmail.com");
        ResponseEntity<Contact> response = new ResponseEntity<Contact>(contact, HttpStatus.OK);
        return response;
    }*/
    
    @RequestMapping(value = "/deleteContact/{id}", method = RequestMethod.DELETE)
    public String deleteContact(@PathVariable String name) {
        
        notes.remove(name);
        return "Eliminado el contacto "+name;
    }
    
}
