/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch10.sample;

import com.home.ln_spring.ch10.domain.ContactSummary;
import com.home.ln_spring.ch10.service.ContactSummaryService;
import com.home.ln_spring.ch10.service.jpa.ContactSummaryUntypeImpl;
import java.util.List;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class ContactSummarySample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:ch10/app-context.xml");
        ctx.refresh();
        
        // Итоговая информация по контактам с нетипизированным результатом.
//        ContactSummaryUntypeImpl contactSummaryUntypeImpl = 
//                ctx.getBean("contactSummaryUntype", ContactSummaryUntypeImpl.class);
//        
//        contactSummaryUntypeImpl.displayAllContactSummary();
        
        ContactSummaryService contactSummaryService =
                ctx.getBean("contactSummaryService", ContactSummaryService.class);
        
        List<ContactSummary> contacts = contactSummaryService.findAll();
        
        for (ContactSummary  contactSummary: contacts) {
            System.out.println(contactSummary);
        }
    }
}
