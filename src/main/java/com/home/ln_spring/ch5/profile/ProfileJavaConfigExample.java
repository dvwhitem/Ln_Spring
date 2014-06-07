/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.profile;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author vitaliy
 */
public class ProfileJavaConfigExample {
 
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        
        context.getEnvironment().setActiveProfiles("highschool");
        context.register(KindergartenConfig.class, HighschoolConfig.class);
        context.refresh();
        
        FoodProviderService foodProviderService =
                context.getBean("foodProviderService", FoodProviderService.class);
        
        List<Food> lunchSet = foodProviderService.provideLunchSet();
        
        for(Food food: lunchSet) {
            System.out.println("Food: " + food.getName());
        }
    }
}
