/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.jsr330;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 *
 * @author vitaliy
 */
@Named("messageRenderer")
@Singleton
public class StandardOutMessageRenderer implements MessageRenderer {

	@Inject
	@Named("messageProvider")
    private MessageProvider messageProvider = null;
	
	public void render() {
        if (messageProvider == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class:"
                            + StandardOutMessageRenderer.class.getName());
        }

        System.out.println(messageProvider.getMessage());	
	}

	public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;		
	}

	public MessageProvider getMessageProvider() {
        return this.messageProvider;
	}
	
}