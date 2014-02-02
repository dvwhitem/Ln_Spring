/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch2;

/**
 *
 * @author vitaliy
 */
public class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider = null;
    @Override
    public void render() {
        if(messageProvider == null) {
            throw new RuntimeException(
                "You must set property messageProvider of class: " 
                + StandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }
    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }
    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
