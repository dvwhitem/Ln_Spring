/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch10.sample;

import com.home.ln_spring.ch10.domain.Contact;
import com.home.ln_spring.ch10.service.ContactService;
import java.util.List;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class SpringJpaSample {
    
     public static void main(String args[]) {
         GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
         ctx.load("classpath:ch10/spring-data-app-context.xml");
         ctx.refresh();
         
         ContactService contactService = ctx.getBean("springJpaContactService", 
                 ContactService.class);
         
         // Find all contatcs
         List<Contact> contacts = contactService.findAll();
         listContacts(contacts);
         
         // Find contact by name
         contacts = contactService.findByFirstName("Scott");
         listContacts(contacts);
         // Find contact by first name and last name
         contacts = contactService.findByFirstNameAndLastName("John", "Smith");
         listContacts(contacts);
     }
     
     private static void listContacts(List<Contact> contacts) {
         System.out.println("");
         System.out.println("Listing contacts without details: ");
         for(Contact contact: contacts) {
             System.out.println(contact);
             System.out.println("");
         }
     }
}
