/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.interaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanNameAware;

/**
 *
 * @author vitaliy
 */
public class LoggingBean implements BeanNameAware {


    private static final Log log = LogFactory.getLog(LoggingBean.class);
    
    private String beanName = null;

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
    
    public void someOperation() {
        if(log.isInfoEnabled()) {
            log.info("Bean [" + beanName + "] - someOperation()");
        }
    }
}