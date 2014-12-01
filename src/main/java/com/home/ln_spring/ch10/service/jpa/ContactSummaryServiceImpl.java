/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch10.service.jpa;

import com.home.ln_spring.ch10.domain.ContactSummary;
import com.home.ln_spring.ch10.service.ContactSummaryService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vitaliy
 */
@Service("contactSummaryService")
@Repository
@Transactional
public class ContactSummaryServiceImpl implements ContactSummaryService {
   
    @PersistenceContext
    private EntityManager em;
    
    @Transactional(readOnly = true)
    public List<ContactSummary> findAll() {

        List<ContactSummary> result = em.createQuery(
                "select new com.home.ln_spring.ch10.domain.ContactSummary("
                + "c.firstName, c.lastName, t.telNumber) from Contact c "
                + "left join c.contactTelDetails t where t.telType = 'Home'",
                ContactSummary.class
        ).getResultList();
        return result;
    }
}
