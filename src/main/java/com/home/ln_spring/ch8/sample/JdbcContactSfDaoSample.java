/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch8.sample;

import com.home.ln_spring.ch8.dao.ContactSfDao;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class JdbcContactSfDaoSample {
    
    public static void main(String[] args) {
                GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:ch8/app-context-sf.xml");
        ctx.refresh();
        
        ContactSfDao contactSfDao = ctx.getBean("contactSfDao", ContactSfDao.class);
        
        System.out.println(contactSfDao.getFirstNameById(1));
    }
}
