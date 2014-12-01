/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch10.service;

import com.home.ln_spring.ch10.domain.ContactSummary;
import java.util.List;

/**
 *
 * @author vitaliy
 */
public interface ContactSummaryService {
    public List<ContactSummary> findAll();
}
