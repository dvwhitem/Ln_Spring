/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.ln_spring.ch9.dao.hibernate;

import com.home.ln_spring.ch9.dao.ContactDao;
import com.home.ln_spring.ch9.domain.TestContact;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vitaliy
 */
@Repository("contactDao")
@Transactional
public class ContactDaoImpl implements ContactDao {

    private Log log = LogFactory.getLog(ContactDaoImpl.class);

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestContact> findAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from Contact c").list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestContact> findAllWithDetail() {
        return sessionFactory.getCurrentSession()
                .getNamedQuery("Contact.findAllWithDetail").list();
    }

    public TestContact findById(int id) {
        return (TestContact) sessionFactory.getCurrentSession().
                getNamedQuery("Contact.findById").setParameter("id", id).uniqueResult();
    }

    @Override
    public TestContact save(TestContact contact) {
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
        log.info("Contact saved with id: " + contact.getId());
        return contact;
    }

    @Override
    public void delete(TestContact contact) {
        sessionFactory.getCurrentSession().delete(contact);
        log.info("Contact deleted with id: " + contact.getId());
    }

}
