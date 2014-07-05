/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch9.sample;

import com.home.ln_spring.ch9.domain.ContactTelDetail;
import com.home.ln_spring.ch9.dao.ContactDao;
import com.home.ln_spring.ch9.domain.Contact;
import com.home.ln_spring.ch9.domain.Hobby;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class SpringHibernateSample {

    public static void main(String[] args) {
        
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:ch9/app-context.xml");
        context.refresh();
        
        ContactDao contactDao = context.getBean("contactDao", ContactDao.class);
        //List<Contact> contacts = contactDao.findAll();
       //List<Contact> contacts = contactDao.findAllWithDetail();
        //listContacts(contacts);
        //listContactsWithDetail(contacts);
        
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
        //output:
        //Listing contacts with details : 

        //Contact Tel Detail - Id: 2, Contact id: 1, Type: Home, Number: 1234567890
        //Contact Tel Detail - Id: 1, Contact id: 1, Type: Mobile, Number: 1234567890
        //Hobby :Movies
        //Hobby :Swimming

        //Contact Tel Detail - Id: 3, Contact id: 2, Type: Home, Number: 1234567890
        //Hobby :Swimming
        
        
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        
        //Contact contact;
        //contact = contactDao.findById(1);
        //System.out.println();
        //System.out.println("Contact with id 1: " + contact);
        //System.out.println();
        
        //output:
        //Contact with id 1: Contact - Id: 1, First name: Clarence, Last name: Ho, Birthday: 1980-07-30
        
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++        
        
        //Contact contact = new Contact();
        //contact.setFirstName("James");
        //contact.setLastName("Rodriguez");
        //contact.setBirthDate(new Date());
        //ContactTelDetail contactTelDetail = 
        //        new ContactTelDetail("Mobile", "111111111");
        //contact.addContactTelDetail(contactTelDetail);
        //contactDao.save(contact);
        //List<Contact> contacts = contactDao.findAllWithDetail();
        //listContactsWithDetail(contacts); 
        
        //output:
        //Listing contacts with details:
        //Contact - Id: 3, First name: John, Last name: Smith, Birthday: 1964-02-28

        //Contact - Id: 1, First name: Clarence, Last name: Ho, Birthday: 1980-07-30
        //Contact Tel Detail - Id: 1, Contact id: 1, Type: Mobile, Number: 1234567890
        //Contact Tel Detail - Id: 2, Contact id: 1, Type: Home, Number: 1234567890
        //Hobby :Movies
        //Hobby :Swimming

        //Contact - Id: 5, First name: James, Last name: Rodriguez, Birthday: 2014-07-05
        //Contact Tel Detail - Id: 5, Contact id: 5, Type: Mobile, Number: 111111111

        //Contact - Id: 2, First name: Scott, Last name: Tiger, Birthday: 1990-11-02
        //Contact Tel Detail - Id: 3, Contact id: 2, Type: Home, Number: 1234567890
        //Hobby :Swimming
        
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++        
        
//        Contact contact = new Contact();
//        contact = contactDao.findById(1);
//        contact.setFirstName("Kim Fung");
//        Set<ContactTelDetail> contactTels = contact.getContactTelDetails();
//        ContactTelDetail toDeteteContactTel = null;
//        for(ContactTelDetail contactTelDetail: contactTels) {
//            if(contactTelDetail.getTelType().equals("Home")) {
//                toDeteteContactTel = contactTelDetail;
//            }
//        }
//        contact.removeContactTelDetail(toDeteteContactTel);
//        contactDao.save(contact);
//        List<Contact> contacts = contactDao.findAllWithDetail();
//        listContactsWithDetail(contacts);
//        
//        Listing contacts with details:
//        Contact - Id: 3, First name: John, Last name: Smith, Birthday: 1964-02-28
//
//        Contact - Id: 5, First name: James, Last name: Rodriguez, Birthday: 2014-07-05
//        Contact Tel Detail - Id: 5, Contact id: 5, Type: Mobile, Number: 111111111
//
//        Contact - Id: 1, First name: Kim Fung, Last name: Ho, Birthday: 1980-07-30
//        Contact Tel Detail - Id: 1, Contact id: 1, Type: Mobile, Number: 1234567890
//        Hobby :Movies
//        Hobby :Swimming
//
//        Contact - Id: 2, First name: Scott, Last name: Tiger, Birthday: 1990-11-02
//        Contact Tel Detail - Id: 3, Contact id: 2, Type: Home, Number: 1234567890
//        Hobby :Swimming
        
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
        
        //Contact contact = contactDao.findById(1);
        //contactDao.delete(contact);
        //List<Contact> contacts = contactDao.findAllWithDetail();
        //listContactsWithDetail(contacts);
        
        //output:
        //Listing contacts with details:
        //Contact - Id: 3, First name: John, Last name: Smith, Birthday: 1964-02-28

        //Contact - Id: 5, First name: James, Last name: Rodriguez, Birthday: 2014-07-05
        //Contact Tel Detail - Id: 5, Contact id: 5, Type: Mobile, Number: 111111111

        //Contact - Id: 2, First name: Scott, Last name: Tiger, Birthday: 1990-11-02
        //Contact Tel Detail - Id: 3, Contact id: 2, Type: Home, Number: 1234567890
        //Hobby :Swimming
        
        
    }
    
    private static void listContacts(List<Contact> contacts) {
        
        System.out.println("");
        System.out.println("Listing contacts without details : ");
        for(Contact contact: contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }
    
    private static void listContactsWithDetail(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listing contacts with details:");
        for (Contact contact : contacts) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
                    System.out.println(contactTelDetail);
                }
            }
            if (contact.getHobbies() != null) {
                for (Hobby hobby : contact.getHobbies()) {
                    System.out.println(hobby);
                }
            }
            System.out.println();
        }
    }
}
