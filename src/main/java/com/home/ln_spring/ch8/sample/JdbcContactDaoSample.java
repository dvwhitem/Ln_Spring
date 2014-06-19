/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch8.sample;

import com.home.ln_spring.ch8.dao.ContactDao;
import com.home.ln_spring.ch8.domain.Contact;
import com.home.ln_spring.ch8.domain.ContactTelDetail;
import java.util.List;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class JdbcContactDaoSample {
    
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:ch8/app-context-xml.xml");
        ctx.refresh();
        
        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
        
       // System.out.println("First name for contact id 3 is : " + contactDao.findLastNameById(3));
        
        List<Contact> contacts = contactDao.findAll();
        for(Contact contact: contacts) {
            System.out.println(contact);
            if(contact.getContactTelDetails() != null) {
                for(ContactTelDetail contactTelDetail: contact.getContactTelDetails()) {
                    System.out.println("----" + contactTelDetail);
                }
            }
        }
        
        System.out.println("---------------------------------");
        
        List<Contact> contactsWithTelDetail = contactDao.findAllWithDetail();
        for(Contact contact: contactsWithTelDetail) {
            System.out.println(contact);
            if(contact.getContactTelDetails() != null) {
                for(ContactTelDetail contactTelDetail: contact.getContactTelDetails()) {
                    System.out.println("----" + contactTelDetail);
                }
            }
            System.out.println();
        }
    }
    
}
