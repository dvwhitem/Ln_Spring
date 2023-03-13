/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.context;

import java.util.Locale;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class MessageSourceDemo {
    
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new 
        GenericXmlApplicationContext();
        
        context.load("classpath:appContext/messageSource.xml");
        context.refresh();
        
        Locale english = Locale.ENGLISH;
        Locale czech = new Locale("cs", "CZ");
        
        System.out.println(context.getMessage("msg", null, english));
        System.out.println(context.getMessage("msg", null ,czech));
        
        System.out.println(context.getMessage(
                "nameMsg", new Object[] {"John", "Jerry", "James"}, english));
    }
}
