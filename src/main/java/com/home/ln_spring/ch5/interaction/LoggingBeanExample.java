/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.interaction;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class LoggingBeanExample {

    public static void main(String[] args) {
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    	ctx.load("classpath:interaction/logging.xml");
    	ctx.refresh();
        
        LoggingBean bean = (LoggingBean) ctx.getBean("loggingBean");
        bean.someOperation();
    }
}