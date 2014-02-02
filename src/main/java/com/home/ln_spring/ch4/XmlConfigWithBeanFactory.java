/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch4;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

/**
 *
 * @author vitaliy
 */
public class XmlConfigWithBeanFactory {

   public static void main(String args[]) {
       
       DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
       XmlBeanDefinitionReader rdr = new XmlBeanDefinitionReader(factory);
       rdr.loadBeanDefinitions(
               new FileSystemResource("src/main/resources/xmlBeanFactory.xml"));
       
       Oracle oracle = factory.getBean("oracle", Oracle.class);
       System.out.println(oracle.defineMeaningOfLife());
   }
}
