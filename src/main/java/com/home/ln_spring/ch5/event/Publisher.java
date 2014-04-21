/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class Publisher implements ApplicationContextAware{
    
    private ApplicationContext ctx;
    
    public static void main(String[] args) {
        ApplicationContext context = 
                new ClassPathXmlApplicationContext("classpath:events/events.xml");
        
        Publisher p = (Publisher) context.getBean("publisher");
        p.publish("Hello World!!!");
        p.publish("The quik brown fox jumperd over the lazy dog");
    }

    @Override
    public void setApplicationContext(ApplicationContext ac) 
            throws BeansException {
        this.ctx = ac;
    }
    
    public void publish(String message) {
        ctx.publishEvent(new MessageEvent(this, message));
    }
    
}
