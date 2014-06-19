/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch8.sample;

import com.home.ln_spring.ch8.dao.ContactDao;
import com.home.ln_spring.ch8.dao.plain.PlainContactDao;
import com.home.ln_spring.ch8.domain.Contact;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author vitaliy
 */
public class PlainJdbcSample {

    private static ContactDao contactDao = new PlainContactDao();
    
    public static void main(String[] args) {
        System.out.println("Listing initial contact data: ");
        listAllContacts();
        
        System.out.println("");
        
        System.out.println("Insert a new contact");
        Contact contact = new Contact();
        contact.setFirstName("Jack");
        contact.setLastName("Rayan");
        contact.setBirthDate(
                 new Date((new GregorianCalendar(2000, 11, 16)).getTime().getTime()));
        contactDao.insert(contact);
        System.out.println("Listing contact data after new contact created: ");
        listAllContacts();
        
        System.out.println("Delete contact #" + contact.getId());
        contactDao.delete(contact.getId());
        System.out.println("Deleting contact data after new contact deleted: ");
        listAllContacts();
    }
    
    private static void listAllContacts() {
        List<Contact> contacts = contactDao.findAll();
        
        for(Contact contact: contacts) {
            System.out.println(contact);
        }
    }
}
