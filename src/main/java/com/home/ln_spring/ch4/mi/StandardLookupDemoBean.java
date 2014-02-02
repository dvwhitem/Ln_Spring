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
public class StandardLookupDemoBean implements DemoBean {
    
    private MyHelper myHelper;

    public void setMyHelper(MyHelper myHelper) {
        this.myHelper = myHelper;
    }

    public MyHelper getMyHelper() {
        return myHelper;
    }
    
    public void someOperation() {
        myHelper.doSomethingHelpful();
    }
}
