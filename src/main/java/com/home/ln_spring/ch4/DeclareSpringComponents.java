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
public class DeclareSpringComponents {
    public static void main(String args[]) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        //ctx.load("classpath:app-context-annotation.xml");
        ctx.load("classpath:app-context-xml.xml");
        ctx.refresh();
        
        MessageRenderer mr = ctx.getBean("messageRenderer", MessageRenderer.class);
        mr.render();
        
        // Constructor injection
//        MessageProvider mp = ctx.getBean("messageProvider", MessageProvider.class);
//        System.out.println(mp.getMessage());
        
    }
}
