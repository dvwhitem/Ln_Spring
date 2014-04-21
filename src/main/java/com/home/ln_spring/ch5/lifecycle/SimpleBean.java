/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.ln_spring.ch5.lifecycle;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class SimpleBean {

    private static final String DEFAULT_NAME = "Luke Skywalker";

    private String name = null;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void init() {
        System.out.println("Initialising bean (AGE " + Integer.MIN_VALUE + ")");
        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set age property "
                    + SimpleBean.class);
        }
    }
    
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:lifecycle/initMethod.xml");
        ctx.refresh();
        
        SimpleBean simpleBean1 = getBean("simpleBean1", ctx);
        SimpleBean simpleBean2 = getBean("simpleBean2", ctx);
        SimpleBean simpleBean3 = getBean("simpleBean3", ctx);
    }

    private static SimpleBean getBean(String beanName, ApplicationContext ctx) {
        try {
            SimpleBean sb = (SimpleBean) ctx.getBean(beanName);
            System.out.println(sb);
            return sb;
        } catch (BeanCreationException ex) {
            System.out.println("An error occured in bean configuration1: "
                    + ex.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        return "SimpleBean{" + "name=" + name + ", age=" + age + '}';
    }
}
