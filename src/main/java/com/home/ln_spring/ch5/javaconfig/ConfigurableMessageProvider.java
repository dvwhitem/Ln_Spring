/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.javaconfig;

/**
 *
 * @author vitaliy
 */
public class ConfigurableMessageProvider implements MessageProvider {
    
    private String message = "Default message";
    
    public ConfigurableMessageProvider() {
        
    }
    
    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
