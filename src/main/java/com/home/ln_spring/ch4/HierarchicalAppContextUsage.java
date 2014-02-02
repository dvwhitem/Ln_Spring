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
public class HierarchicalAppContextUsage {

    public static void main(String args[]) {
        GenericXmlApplicationContext parent = 
                new GenericXmlApplicationContext();
        parent.load("classpath:parent.xml");
        parent.refresh();
        
        GenericXmlApplicationContext child = 
                new GenericXmlApplicationContext();
        child.load("classpath:app-context-xml.xml");
        child.setParent(parent);
        child.refresh();
        
        SimpleTarget target1 = (SimpleTarget) child.getBean("target1");
        SimpleTarget target2 = (SimpleTarget) child.getBean("target2");
        SimpleTarget target3 = (SimpleTarget) child.getBean("target3");
        
        System.out.println(target1.getVal());
        System.out.println(target2.getVal());
        System.out.println(target3.getVal());
       
    }
}
