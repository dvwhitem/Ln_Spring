/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.ln_spring.ch4.annotation;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author vitaliy
 */
@Service("injectCollection")
public class CollectionInjection {

    @Resource(name = "map")
    private Map<String, Object> map;
    @Resource(name = "props")
    private Properties props;
    @Resource(name = "set")
    private Set set;
    @Resource(name = "list")
    private List list;

    public static void main(String args[]) {
        GenericXmlApplicationContext context
                = new GenericXmlApplicationContext();
        context.load("classpath:app-context-annotation.xml");
        context.refresh();

        CollectionInjection instance
                = (CollectionInjection) context.getBean("injectCollection");
        instance.displayInfo();
    }
    
        public void displayInfo() {
        // Отобразить Map
        System.out.println("\nMap contents:\n");
        for(Map.Entry<String, Object> entry: map.entrySet()) {
            System.out.println("Key: " 
                    + entry.getKey() + " - Value: " + entry.getValue());
        }
        // Отобразить Props
        System.out.println("\nProperties contents:\n");
        for(Map.Entry<Object, Object> entry: props.entrySet()) {
            System.out.println("Key: " 
                    + entry.getKey() + " - Value: " + entry.getValue());
        }
        // Отобразить Set
        System.out.println("\nSet contents:\n");
        for(Object o: set) {
            System.out.println("Value: " + o);
        }
        // Отобразить List
        System.out.println("\nList contents:\n");
        for(Object o: list) {
            System.out.println("Value: " + o);
        }
    }
}
