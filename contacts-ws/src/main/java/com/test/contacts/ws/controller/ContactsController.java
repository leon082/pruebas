/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.contacts.ws.controller;

import com.test.contacts.ws.model.Contact;
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
    public ResponseEntity<Contact> getAllContacts(){
        Contact contact = new Contact(1L,"Maria","Perea","315-897452","correo@gmail.com");
        ResponseEntity<Contact> response = new ResponseEntity<Contact>(contact, HttpStatus.OK);
        return response;
    }
    
     @RequestMapping(value = "/getContactByID/{id}", method = RequestMethod.GET)
    public ResponseEntity<Contact> getContact(@PathVariable String id){
        Contact contact = new Contact(1L,"Maria","Perea","315-897452","correo@gmail.com");
        ResponseEntity<Contact> response = new ResponseEntity<Contact>(contact, HttpStatus.OK);
        return response;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact){
        Contact cnt = new Contact(1L,"Maria","Perea","315-897452","correo@gmail.com");
        ResponseEntity<Contact> response = new ResponseEntity<Contact>(cnt, HttpStatus.OK);
        return response;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<Contact> updateContact(){
        Contact contact = new Contact(1L,"Maria","Perea","315-897452","correo@gmail.com");
        ResponseEntity<Contact> response = new ResponseEntity<Contact>(contact, HttpStatus.OK);
        return response;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity<Contact> deleteContact(){
        Contact contact = new Contact(1L,"Maria","Perea","315-897452","correo@gmail.com");
        ResponseEntity<Contact> response = new ResponseEntity<Contact>(contact, HttpStatus.OK);
        return response;
    }
    
    
}
