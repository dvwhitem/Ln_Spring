/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.ln_spring.ch10.sample;

import com.home.ln_spring.ch10.domain.ContactAudit;
import com.home.ln_spring.ch10.service.ContactAuditService;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class SpringJpaAuditSample {

    public static void main(String[] args) {
        GenericXmlApplicationContext context
                = new GenericXmlApplicationContext();
        context.load("classpath:ch10/spring-data-app-context.xml");
        context.refresh();

        ContactAuditService auditService = context.getBean("contactAuditService",
                ContactAuditService.class);
        List<ContactAudit> contacts = auditService.findAll();
        listContacts(contacts);

        // Add new contact
        System.out.println("Add new contact");
        ContactAudit contact = new ContactAudit();
        contact.setFirstName("John");
        contact.setLastName("Smith");
        contact.setBirthDate(new Date());
        auditService.save(contact);
        contacts = auditService.findAll();
        listContacts(contacts);

        contact = auditService.findById(41l);
        System.out.println("");
        System.out.println("Contact with id 41: " + contact);
        System.out.println("");

        // Update Contact
        System.out.println("Update contact");
        contact.setFirstName("Joaquin");
        //auditService.save(contact);
        contacts = auditService.findAll();
        listContacts(contacts);

        // Search entry audit by number version
        ContactAudit oldContact = auditService.findAuditByRevision(41l, 29);
        System.out.println("");
        System.out.println("Old Contact with id 41 and rev 1: " + oldContact);
        System.out.println("");
        oldContact = auditService.findAuditByRevision(41l, 30);
        System.out.println("");
        System.out.println("Old Contact with id 41 and rev 2: " + oldContact);
        System.out.println("");
    }

    private static void listContacts(List<ContactAudit> contacts) {
        System.out.println("");
        System.out.println("Listing contacts without details: ");
        for (ContactAudit contactAudit : contacts) {
            System.out.println(contactAudit);
            System.out.println();
        }
    }
}
