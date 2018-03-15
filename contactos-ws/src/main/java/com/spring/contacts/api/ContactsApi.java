/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.contacts.api;

import com.spring.contacts.dto.Contact;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luis.leon
 */
@RestController
public class ContactsApi {
    @RequestMapping(value="/product", method = RequestMethod.GET)
    public Contact getById(Long id){
        return new Contact(1L,"Jhon","Doe","311569874", "correo@gmail.com");
    }
    
}
