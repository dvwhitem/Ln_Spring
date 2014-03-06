/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch4.inheritance;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class SimpleBean {
    
    public String name;
    
    public int age;
    
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-xml.xml");
        ctx.refresh();
        
        SimpleBean parent = (SimpleBean) ctx.getBean("inheritParent");
        SimpleBean child = (SimpleBean) ctx.getBean("inheritChild");
        
        System.out.println("Parent: " + parent + "\n");
        System.out.println("Child: " + child + "\n");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SimpleBean{" + "name=" + name + ", age=" + age + '}';
    }

}
