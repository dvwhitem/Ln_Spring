/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch8.dao;

import com.home.ln_spring.ch8.domain.Contact;
import java.util.List;

/**
 *
 * @author vitaliy
 */
public interface ContactDao {
    
    public List<Contact> findAll();
    
    public String findFirsNameById(int id);
    
    public String findLastNameById(int id);
    
    public List<Contact> findByFirstName(String firstName);

    public List<Contact> findAllWithDetail();
    
    public void insert(Contact contact);
    
    public void insertWithDetail(Contact contact);
    
    public void update(Contact contact);
    
    public void delete(int contactId);
}
