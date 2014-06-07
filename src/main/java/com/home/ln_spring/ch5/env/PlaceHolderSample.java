/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.env;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class PlaceHolderSample {

    public static void main(String[] args) {
        
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:env/env.xml");
        ctx.refresh();
        
        AppProperty ap = ctx.getBean("appProperty", AppProperty.class);
        System.out.println("application.home: " + ap.getApplicationHome());
        System.out.println("user.home: " + ap.getUserHome());
    }
}
