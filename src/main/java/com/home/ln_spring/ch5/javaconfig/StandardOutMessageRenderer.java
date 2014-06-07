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
public class StandardOutMessageRenderer implements MessageRenderer {
    
    private MessageProvider messageProvider = null;
    
    @Override
    public void render() {
        if(messageProvider == null) {
            throw new RuntimeException("You must set property");
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }
    
    
}
