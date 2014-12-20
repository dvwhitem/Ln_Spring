/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch10.springjpa.auditor;

import org.springframework.data.domain.AuditorAware;

/**
 *
 * @author vitaliy
 */
public class AuditorAwareBean implements AuditorAware<String>{

    @Override
    public String getCurrentAuditor() {
        return "ln_spring";
    }
    
}
