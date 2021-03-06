/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch10.service.jpa;

import com.home.ln_spring.ch10.domain.Contact;
import com.home.ln_spring.ch10.domain.Contact_;
import com.home.ln_spring.ch10.service.ContactServiceOld;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vitaliy
 */
@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImplOld implements ContactServiceOld {
    
    private Log log = LogFactory.getLog(ContactServiceImplOld.class);
    
    final static String ALL_CONTACT_NATIVE_QUERY =
            "select contact_id, first_name, last_name, birth_date, version from contact";
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Contact> findAll() {
        List<Contact> contacts = em.createNamedQuery("Contact.findAll", 
                Contact.class).getResultList();
        return contacts;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAllWithDetail() {
        List<Contact> contacts = em.createNamedQuery(
                "Contact.findAllWithDetail", Contact.class).getResultList();
        
        return contacts;
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        TypedQuery<Contact> query = em.createNamedQuery("Contact.findById", 
                Contact.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Contact save(Contact contact) {
        if (contact.getId() <= 0) { // Insert Contact
            log.info("Inserting new contact");
            em.persist(contact);
        } else {                       // Update Contact
            em.merge(contact);
            log.info("Updating existing contact");
        }
        log.info("Contact saved with id: " + contact.getId());
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        Contact mergedContact = em.merge(contact);
        em.remove(mergedContact);
        log.info("Contact with ID: " + contact.getId() 
                + " deleted successfully");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAllByNativeQuery() {
        return em.createNativeQuery(ALL_CONTACT_NATIVE_QUERY, "contactResult")
                .getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findByCriteriaQuery(String firstName, String lastName) {
        log.info("Finding contact for firstName: " 
                + firstName + " and lastName: " + lastName);
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Contact> criteriaQuery = cb.createQuery(Contact.class);
        Root<Contact> contactRoot = criteriaQuery.from(Contact.class);
        contactRoot.fetch(Contact_.contactTelDetails, JoinType.LEFT);
        contactRoot.fetch(Contact_.hobbies, JoinType.LEFT);
        
        criteriaQuery.select(contactRoot).distinct(true);
        
        Predicate criteria = cb.conjunction();
        if(firstName != null) {
            Predicate p = cb.equal(contactRoot.get(Contact_.firstName), 
                    firstName);
            criteria = cb.and(criteria, p);
        }
        
        if(lastName != null) {
            Predicate p = cb.equal(contactRoot.get(Contact_.lastName),
                    lastName);
            criteria = cb.and(criteria, p);
        }
        
        criteriaQuery.where(criteria);
        List<Contact> result = em.createQuery(criteriaQuery).getResultList();
        return result;
    }
    
}
