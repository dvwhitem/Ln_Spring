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
public class lookupDemo {
    
    public static void main(String args[]) {
        GenericXmlApplicationContext context =
                new GenericXmlApplicationContext();
        context.load("classpath:lookup.xml");
        DemoBean abstractDemoBean = 
                (DemoBean) context.getBean("abstractLookupBean");
        DemoBean standardDemoBean =
                (DemoBean) context.getBean("standardLookupBean");
        displayInfo(standardDemoBean);
        displayInfo(abstractDemoBean);
    }
    
    public static void displayInfo(DemoBean bean) {
        MyHelper helper1 = bean.getMyHelper();
        MyHelper helper2 = bean.getMyHelper();
        
        System.out.println("Helper Instances the Same?: " 
                + (helper1 == helper2));
        
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for(int x = 0; x < 100000; x++) {
            MyHelper helper = bean.getMyHelper();
            helper.doSomethingHelpful();
        }
        stopWatch.stop();
        System.out.println("100000 gets took " 
                + stopWatch.getTotalTimeMillis() + " ms");
    }
}
