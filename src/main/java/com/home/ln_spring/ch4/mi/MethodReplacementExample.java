/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch4.mi;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 *
 * @author vitaliy
 */
public class MethodReplacementExample {
    
    public static void main(String args[]) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("classpath:replacement.xml");
        ctx.refresh();
        
        ReplacementTarget replacementTarget = 
                (ReplacementTarget) ctx.getBean("replacementTarget");
        ReplacementTarget standardTarget = 
                (ReplacementTarget) ctx.getBean("standardTarget");
        
        displayInfo(replacementTarget);
        displayInfo(standardTarget);
    }
    
    private static void displayInfo(ReplacementTarget target) {
        System.out.println(target.formatMessage("Hello World!"));
        
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");
        
        for(int x = 0; x < 1000000; x++) {
            String out = target.formatMessage("foo");
        }
        stopWatch.stop();
        
        System.out.println("1000000 invocations took: " 
                + stopWatch.getTotalTimeMillis() + " ms.");
    }
}
