/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch8.sample;

import com.home.ln_spring.ch8.dao.ContactDao;
import com.home.ln_spring.ch8.domain.Contact;
import com.home.ln_spring.ch8.domain.ContactTelDetail;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.aspectj.util.LangUtil;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class AnnotationJdbcDaoSample {

    public static void main(String[] args) {
        
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:ch8/app-context-annotation.xml");
        context.refresh();
        
        ContactDao contactDao = context.getBean("contactDao", ContactDao.class);
        List<Contact> contacts = contactDao.findAll();
        listContacts(contacts);
        
        System.out.println("Find by first name: ");
        
        contacts = contactDao.findByFirstName("Clarence");
        listContacts(contacts);
        
//        System.out.println("Update contact with id : ");
//        Contact contact = new Contact();
//        contact.setId(2);
//        contact.setFirstName("Jack");
//        contact.setLastName("Rodwell");
//        contact.setBirthDate(
//                new Date((new GregorianCalendar(1987, 1, 8)).getTime().getTime()));
//        contactDao.update(contact);
//        
//        contacts = contactDao.findAll();
//        listContacts(contacts);
        
//        System.out.println("Insert contact");
//        System.out.println();
//        Contact contact1 = new Contact();
//        contact1.setFirstName("Rod");
//        contact1.setLastName("Johnson");
//        contact1.setBirthDate(
//                new Date((new GregorianCalendar(1987, 1, 8)).getTime().getTime()));
//        contactDao.insert(contact1);
//        
//        contacts = contactDao.findAll();
//        listContacts(contacts);
        
        System.out.println("Insert with BatchSqlUpdate");
        System.out.println();
        Contact contact2 = new Contact();
        contact2.setFirstName("Michael");
        contact2.setLastName("Jackson");
        contact2.setBirthDate(
                new Date((new GregorianCalendar(1964, 10, 1)).getTime().getTime()));
        
        List<ContactTelDetail> contactTelDetails = new ArrayList<ContactTelDetail>();
        ContactTelDetail contactTelDetail = new ContactTelDetail();
        contactTelDetail.setTelType("Home");
        contactTelDetail.setTelNumber("111111");
        contactTelDetails.add(contactTelDetail);
        contactTelDetail = new ContactTelDetail();
        contactTelDetail.setTelType("Mobile");
        contactTelDetail.setTelNumber("222222");
        contactTelDetails.add(contactTelDetail);
        contact2.setContactTelDetails(contactTelDetails);
        contactDao.insertWithDetail(contact2);
        contacts = contactDao.findAllWithDetail();
        listContacts(contacts);
    }
    
    private static void listContacts(List<Contact> contacts) {
        for(Contact contact: contacts) {
            System.out.println(contact);
            if(contact.getContactTelDetails() != null) {
                for(ContactTelDetail contactTelDetail: contact.getContactTelDetails()) {
                    System.out.println("-------" + contactTelDetail);
                }
            }
            System.out.println();
        }
    }
}
