/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.ln_spring.ch4.annotation;

import com.home.ln_spring.ch4.MessageProvider;
import org.springframework.stereotype.Service;

/**
 *
 * @author vitaliy
 */
//@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {

    public String getMessage() {
        return "Spring DI annotation";
    }
}
