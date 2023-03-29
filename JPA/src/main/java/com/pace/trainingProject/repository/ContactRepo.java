package com.pace.trainingProject.repository;

import com.pace.trainingProject.entitycLass.Contact;

import java.util.List;

public interface ContactRepo {
    public void saveContact(Contact contact);

    public List<Contact> getAllContacts();

    public Contact getContactById(int id);

    public Contact updateContact(Contact contact);

    public void deleteContact(int id);
}
