/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch4;

/**
 *
 * @author vitaliy
 */
public class StandartOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider = null;
    
    public void render() {
    
        if(messageProvider == null) {
            throw new RuntimeException("You must set property messageProvider");
        }
        System.out.println(messageProvider.getMessage());
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    } 
}
