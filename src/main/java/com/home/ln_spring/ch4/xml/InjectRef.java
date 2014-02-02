/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch4.xml;

import com.home.ln_spring.ch4.Oracle;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class InjectRef {

    private Oracle oracle;

    public void setOracle(Oracle oracle) {
        this.oracle = oracle;
    }
    
    public static void main(String args[]) {
        GenericXmlApplicationContext context = 
                new GenericXmlApplicationContext();
        context.load("classpath:app-context-xml.xml");
        context.refresh();
        
        InjectRef ir = (InjectRef) context.getBean("injectRef");
        
        System.out.println(ir);
    }
    
    public String toString() {
        return oracle.defineMeaningOfLife();
    }
}
