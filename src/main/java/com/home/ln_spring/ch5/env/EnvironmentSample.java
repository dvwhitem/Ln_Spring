/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.env;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

/**
 *
 * @author vitaliy
 */
public class EnvironmentSample {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx 
                = new GenericXmlApplicationContext();
        ctx.refresh();
        
        ConfigurableEnvironment env = ctx.getEnvironment();
        MutablePropertySources propertySources = env.getPropertySources();
        Map appMap = new HashMap();
        appMap.put("user.home", "/home/vitaliy/NetBeansProjects/Ln_Spring");
        propertySources.addFirst(new MapPropertySource("SPRING3_MAP", appMap));
        
        System.out.println("user.home: " + System.getProperty("user.home"));
        System.out.println("JAVA_HOME: " + System.getProperty("JAVA_HOME"));
        
        System.out.println("user.home: " + env.getProperty("user.home"));
        System.out.println("JAVA_HOME: " + env.getProperty("JAVA_HOME"));
    }
}
