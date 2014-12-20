/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch10.repository;

import com.home.ln_spring.ch10.domain.ContactAudit;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vitaliy
 */
public interface ContactAuditRepository 
extends CrudRepository<ContactAudit, Long>{
    
}
