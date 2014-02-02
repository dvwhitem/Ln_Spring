/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class HelloWorldSpringDI {

    public static void main(String args[]) {
        // Игициализация ApplicationContext.
        ApplicationContext context = 
                new ClassPathXmlApplicationContext("app-context.xml");
        
        MessageRenderer mr = context.getBean("renderer", MessageRenderer.class);
        mr.render();
        
        
    }
}
