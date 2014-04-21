/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.factory;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class MessageDigestrExample {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = 
                new GenericXmlApplicationContext();
        
        context.load("classpath:factory/factory.xml");
        context.refresh();
        
        MessageDigester digester = 
                (MessageDigester) context.getBean("digester");
        digester.digest("Hello World!");
    }
}
