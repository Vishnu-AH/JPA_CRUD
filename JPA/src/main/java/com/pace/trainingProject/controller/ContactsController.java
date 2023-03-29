package com.pace.trainingProject.controller;

import com.pace.trainingProject.service.ContactService;
import com.pace.trainingProject.entitycLass.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
public class ContactsController {
    @Autowired
    private ContactService contactService;
    @PostMapping("/contact")
    public void saveContact(@RequestBody Contact contact){
        contactService.saveContact(contact);
    }
    @GetMapping("/contact/{id}")
    public Contact getContactById(@PathVariable int id){
        return contactService.getContactById(id);
    }
    @GetMapping("/contact")
    public List<Contact> getAllContacts(){
        return contactService.listOfContacts();
    }
    @PutMapping("/contact/{id}")
    public void updateContact(@PathVariable int id, @RequestBody Contact contact){
        contactService.updateContact(id,contact);
    }
    @DeleteMapping("/contact/{id}")
    public void deleteContact(@PathVariable int id){
        contactService.deleteContact(id);
    }

}
