/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch4.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class InjectSimpleSpel {

    private String name;
    
    private int age;
    
    private float height;
    
    private boolean programmer;
    
    private Long ageInSeconds;
    
    public static void main(String args[]) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-xml.xml");
        ctx.refresh();
        InjectSimpleSpel spel = 
                (InjectSimpleSpel) ctx.getBean("injectSimpleSpel");
        
        System.out.println(spel);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public void setAgeInSeconds(Long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }

    @Override
    public String toString() {
        return "InjectSimpleSpel{" + "name=" + name + ", age=" + age + ", height=" + height + ", programmer=" + programmer + ", ageInSeconds=" + ageInSeconds + '}';
    }
}
