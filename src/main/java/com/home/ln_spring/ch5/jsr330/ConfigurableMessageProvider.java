/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.jsr330;

import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author vitaliy
 */
@Named("messageProvider")
public class ConfigurableMessageProvider implements MessageProvider {

	private String message = "Default message";

	public ConfigurableMessageProvider() {
	}
	
	@Inject
	@Named("message")
	public ConfigurableMessageProvider(String message) {
		this.message = message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}	
	
}
