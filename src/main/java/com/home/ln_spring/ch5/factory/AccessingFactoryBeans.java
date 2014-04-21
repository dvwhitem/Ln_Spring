/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.factory;

import java.security.MessageDigest;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class AccessingFactoryBeans {
    
    public static void main(String[] args) {
        GenericXmlApplicationContext context = 
                new GenericXmlApplicationContext();
        
        context.load("classpath:factory/factory.xml");
        context.refresh();
        
        MessageDigest digest = (MessageDigest) context.getBean("shaDigest");
        
        MessageDigestFactoryBean factoryBean =
                (MessageDigestFactoryBean) context.getBean("&shaDigest");
        
        try {
            MessageDigest shaDigest = factoryBean.getObject();
            System.out.println(shaDigest.digest("HELLO WORLD!".getBytes()));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
