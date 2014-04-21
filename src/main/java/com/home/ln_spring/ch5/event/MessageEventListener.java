/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.event;

import org.springframework.context.ApplicationListener;

/**
 *
 * @author vitaliy
 */
public class MessageEventListener implements ApplicationListener<MessageEvent> {

    @Override
    public void onApplicationEvent(MessageEvent e) {
        MessageEvent me = (MessageEvent) e;
        System.out.println("Received: " + me.getMessage());
        
    }
    
}
