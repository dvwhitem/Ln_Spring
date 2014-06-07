/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class JavaConfigSimpleExample {

    public static void main(String[] args) {
        ApplicationContext context = 
                //new ClassPathXmlApplicationContext("classpath:app-context.xml");
                new AnnotationConfigApplicationContext(AppConfig.class);
        
        MessageRenderer renderer = 
                context.getBean("messageRenderer", MessageRenderer.class);
        
        renderer.render();
    }
}
