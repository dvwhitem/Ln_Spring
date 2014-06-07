/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 *
 * @author vitaliy
 */
public class ResourceDemo {
    
    public static void main(String[] args) throws Exception {
        ApplicationContext ac = 
                new ClassPathXmlApplicationContext("classpath:events/events.xml");
        
        Resource res1 = 
                ac.getResource("file:/home/vitaliy/NetBeansProjects/Ln_Spring/src/main/resources/test.txt");
        displayInfo(res1);
        
        Resource res2 = ac.getResource("classpath:test.txt");
        displayInfo(res2);
        
        Resource res3 = ac.getResource("http://www.google.com");
        displayInfo(res3);
        
    }
    
    private static void displayInfo(Resource res) throws Exception {
    
        System.out.println(res.getClass());
        System.out.println(res.getURL().getContent());
        System.out.println("");
    }
    
}
