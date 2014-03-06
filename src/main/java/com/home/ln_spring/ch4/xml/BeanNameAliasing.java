/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.ln_spring.ch4.xml;

import java.util.Arrays;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class BeanNameAliasing {

    public static void main(String args[]) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:app-context-xml.xml");
        context.refresh();

        String str1 = (String) context.getBean("name1");
        String str2 = (String) context.getBean("name2");
        String str3 = (String) context.getBean("name3");
        String str4 = (String) context.getBean("name4");
        String str5 = (String) context.getBean("name5");
        String[] alias = (String[]) context.getAliases("name1");

        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
        System.out.println(str3 == str4);
        System.out.println(str4 == str5);
        System.out.println(str1 == str5);
        System.out.println(Arrays.asList(alias));
    }

}
