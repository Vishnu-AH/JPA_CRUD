package com.pace.trainingProject.service;

import com.pace.trainingProject.entitycLass.Contact;
import com.pace.trainingProject.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public void saveContact(Contact contact){
        contactRepository.saveContact(contact);
    }
    public Contact getContactById(int id){
        Contact contact= contactRepository.getContactById(id);
        return contact;
    }
    public List<Contact> listOfContacts(){
        List<Contact> contacts = contactRepository.getAllContacts();
        return contacts;
    }
    public void updateContact(int id,Contact contact){
        Contact excistingContact = contactRepository.getContactById(id);
        if(excistingContact!=null) {
            contact.setId(id);
            contactRepository.updateContact(contact);
            System.out.println(contactRepository.getContactById(id));
        }
    }
    public void deleteContact(int id){
        contactRepository.deleteContact(id);
    }
}
