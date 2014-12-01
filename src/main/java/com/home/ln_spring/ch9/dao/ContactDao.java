/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch9.dao;

import com.home.ln_spring.ch9.domain.TestContact;
import java.util.List;

/**
 *
 * @author vitaliy
 */
public interface ContactDao {

    public List<TestContact> findAll();
    
    public List<TestContact> findAllWithDetail();
    
    public TestContact findById(int id);
    
    public TestContact save(TestContact contact);
    
    public void delete(TestContact contact);
}
