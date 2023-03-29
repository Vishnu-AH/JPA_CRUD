package com.pace.trainingProject.repository;

import com.pace.trainingProject.entitycLass.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ContactRepository implements ContactRepo{
    //@Autowired
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void saveContact(Contact contact){
        entityManager.persist(contact);
    }
    public List<Contact> getAllContacts(){
        Query result = entityManager.createQuery("select c from Contact c");
        List<Contact>list = result.getResultList();
        return list;
    }
    public Contact getContactById(int id){
        return entityManager.find(Contact.class,id);
    }
    @Transactional
    public Contact updateContact(Contact contact){
        return entityManager.merge(contact);
    }
    @Transactional
    public void deleteContact(int id){
        Contact contact = entityManager.find(Contact.class,id);
        entityManager.remove(contact);
        System.out.println(contact);
    }
}
