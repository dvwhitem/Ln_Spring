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
public interface ContactServiceOld {

    public List<Contact> findAll();
    
    public List<Contact> findAllWithDetail();
    
    public List<Contact> findAllByNativeQuery();
    
    public List<Contact> findByCriteriaQuery(String firstName, String lastName);
    
    public Contact findById(Long id);
    
    public Contact save(Contact contact);
    
    public void delete(Contact contact);
}
