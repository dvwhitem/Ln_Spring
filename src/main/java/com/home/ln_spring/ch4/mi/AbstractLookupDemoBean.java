/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch4.mi;

/**
 *
 * @author vitaliy
 */
public abstract class AbstractLookupDemoBean implements DemoBean {
    
    public abstract MyHelper getMyHelper();
    
    public void someOperation() {
         getMyHelper().doSomethingHelpful();
    }
}
