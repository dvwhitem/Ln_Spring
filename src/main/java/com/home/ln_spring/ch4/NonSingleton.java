/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class NonSingleton {
    
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-xml.xml");
        ctx.refresh();
        
        String str1 = (String) ctx.getBean("nonSingleton");
        String str2 = (String) ctx.getBean("nonSingleton");
        
        System.out.println("Identity Equal?: " + (str1 == str2));
        System.out.println("Value Equal:? " + str1.equals(str2));
        System.out.println(str1);
        System.out.println(str2);
    }
}
