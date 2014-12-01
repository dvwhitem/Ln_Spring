/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch10.repository;

import com.home.ln_spring.ch10.domain.Contact;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vitaliy
 */
public interface ContactRepository extends CrudRepository<Contact, Long>{
    
    public List<Contact> findByFirstName(String firstName);
    
    public List<Contact> findByFirstNameAndLastName(String firstName, 
            String lastName);
}
