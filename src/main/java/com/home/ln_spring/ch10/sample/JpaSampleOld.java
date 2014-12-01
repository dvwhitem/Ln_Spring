/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch10.sample;

import com.home.ln_spring.ch10.domain.Contact;
import com.home.ln_spring.ch10.domain.ContactTelDetail;
import com.home.ln_spring.ch10.domain.Hobby;
import com.home.ln_spring.ch10.service.ContactServiceOld;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class JpaSampleOld {
    
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:ch10/app-context.xml");
        ctx.refresh();
        
        ContactServiceOld contactService = 
                ctx.getBean("jpaContactService", ContactServiceOld.class);
        
        //List<Contact> contacts = contactService.findAll();
        //listContacts(contacts);
        
        //List<Contact> contacts = contactService.findAllWithDetail();
        //listContactsWithDetail(contacts);
        
        //Contact contact = contactService.findById(1L);
        //getContactWithDetail(contact);
        
        // Inserting new contact
//        Contact contact = new Contact();
//        contact.setFirstName("Michael");
//        contact.setLastName("Jackson");
//        contact.setBirthDate(new Date());
//        ContactTelDetail contactTelDetail = 
//                new ContactTelDetail("Home", "11111111111");
//        contact.addContactTelDetail(contactTelDetail);
//        contactTelDetail = new ContactTelDetail("Mobile", "2222222222");
//        contact.addContactTelDetail(contactTelDetail);
//        contactService.save(contact);
//        List<Contact> contacts = contactService.findAllWithDetail();
//        listContactsWithDetail(contacts);
        
        
        // Update contact
//        Contact contact = new Contact();
//        contact = contactService.findById(1l);
//        System.out.println("");
//        System.err.println("Contact with id 1 " + contact);
//        System.out.println("");
//        
//        contact.setFirstName("Kim Fung");
//        Set<ContactTelDetail> contactTels = contact.getContactTelDetails();
//        ContactTelDetail toDeleteContactTel = null;
//        for(ContactTelDetail telDetail: contactTels) {
//            if(telDetail.getTelType().equalsIgnoreCase("Home")) {
//                toDeleteContactTel = telDetail;
//            }
//        }
//        contactTels.remove(toDeleteContactTel);
//        contactService.save(contact);
//        contacts = contactService.findAllWithDetail();
//        listContactsWithDetail(contacts);
        
//        Contact contact = new Contact();
//        contact = contactService.findById(1l);
//        contactService.delete(contact);
//        contacts = contactService.findAllWithDetail();
//        listContactsWithDetail(contacts);
        
//          List<Contact> contacts = contactService.findAllByNativeQuery();
//          listContacts(contacts);
        
            List<Contact> conatcts = contactService.findByCriteriaQuery(null, "Jackson");
            listContactsWithDetail(conatcts);
        
          
     }
    
    private static void getContactWithDetail(Contact contact) {
        System.out.println("");
        System.out.println("Contact object without details: ");
        System.out.println(contact);
        
        if(contact.getContactTelDetails() != null) {
            System.out.println("Contact with details: ");
            System.out.println(contact.getContactTelDetails());
        }
        if(contact.getHobbies() != null) {
            System.out.println("Hobbies: ");
            System.out.println(contact.getHobbies());
        }
    }
    
    
    private static void listContacts(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listining contacts without details: ");
        for(Contact contact: contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }
    
    private static void listContactsWithDetail(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listining contacts with details: ");
        for(Contact contact: contacts) {
            System.out.println(contact);
            if(contact.getContactTelDetails() != null) {
                for(ContactTelDetail contactTelDetail: 
                        contact.getContactTelDetails()) {
                    
                    System.out.println(contactTelDetail);
                }
            }
            if(contact.getHobbies() != null) {
                for(Hobby hobby: contact.getHobbies()) {
                    System.out.println(hobby);
                }
            }
            System.out.println();
        }
    }
}
