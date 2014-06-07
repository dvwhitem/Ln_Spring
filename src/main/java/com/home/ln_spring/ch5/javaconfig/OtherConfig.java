/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.javaconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author vitaliy
 */
@Configuration
@PropertySource(value = "classpath:message.properties")
public class OtherConfig {
    
}
