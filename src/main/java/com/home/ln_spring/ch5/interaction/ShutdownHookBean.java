/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.interaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

/**
 *
 * @author vitaliy
 */
public class ShutdownHookBean implements ApplicationContextAware {
    
    private ApplicationContext context;
    
    public void setApplicationContext(ApplicationContext context) {
        if(context instanceof GenericApplicationContext) {
            ((GenericApplicationContext) context).registerShutdownHook();
        }
    }
}
