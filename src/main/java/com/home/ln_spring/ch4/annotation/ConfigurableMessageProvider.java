/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.ln_spring.ch4.annotation;

import com.home.ln_spring.ch4.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author vitaliy
 */
@Service("messageProvider")
public class ConfigurableMessageProvider implements MessageProvider {

    private String message;

//    @Autowired
//    public ConfigurableMessageProvider(
//            @Value("This is a configurable message annotation") String message) {
//        this.message = message;
//    }
    @Autowired
    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
