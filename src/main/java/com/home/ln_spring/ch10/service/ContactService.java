/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch10.service;

import com.home.ln_spring.ch10.domain.Contact;
import java.util.List;

/**
 *
 * @author vitaliy
 */
public interface ContactService {
    
    public List<Contact> findAll();
    
    public List<Contact> findByFirstName(String firstName);
    
    public List<Contact> findByFirstNameAndLastName(String firstName, 
            String lastName);
}
