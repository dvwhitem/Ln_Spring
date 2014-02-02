/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.ln_spring.ch4.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author vitaliy
 */
@Service("injectSimple")
public class InjectSimple {

    @Value("John Doe")
    private String name;
    @Value("35")
    private int age;
    @Value("1.71")
    private float height;
    @Value("false")
    private boolean programmer;
    @Value("1103760000")
    private Long ageInSeconds;

    public static void main(String args[]) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-annotation.xml");
        ctx.refresh();

        InjectSimple simple
                = (InjectSimple) ctx.getBean("injectSimple");
        System.out.println(simple);
    }

    @Override
    public String toString() {
        return "InjectSimple{" + "name=" + name + ", age=" + age + ", height=" + height + ", programmer=" + programmer + ", ageInSeconds=" + ageInSeconds + '}';
    }

}
