/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.profile;

import java.util.List;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy  
 */
public class ProfileXmlConfigExample {

    public static void main(String[] args) {
        
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.getEnvironment().setActiveProfiles("highschool");
        context.load("classpath:profile/*-config.xml");
        context.refresh();
        
        FoodProviderService foodProviderService = 
                context.getBean("foodProviderService", FoodProviderService.class);
        
        List<Food> lunchSet = foodProviderService.provideLunchSet();
        
        for(Food food: lunchSet) {
            System.out.println("Food: " + food.getName());
        }
        
    }
}
