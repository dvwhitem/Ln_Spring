/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch9.dao;

import com.home.ln_spring.ch9.domain.Contact;
import java.util.List;

/**
 *
 * @author vitaliy
 */
public interface ContactDao {

    public List<Contact> findAll();
    
    public List<Contact> findAllWithDetail();
    
    public Contact findById(int id);
    
    public Contact save(Contact contact);
    
    public void delete(Contact contact);
}
