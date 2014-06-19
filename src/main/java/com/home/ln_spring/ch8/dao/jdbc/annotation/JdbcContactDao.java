/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.ln_spring.ch8.dao.jdbc.annotation;

import com.home.ln_spring.ch8.dao.ContactDao;
import com.home.ln_spring.ch8.domain.Contact;
import com.home.ln_spring.ch8.domain.ContactTelDetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vitaliy
 */
@Repository("contactDao")
public class JdbcContactDao implements ContactDao {

    private Log log = LogFactory.getLog(JdbcContactDao.class);

    private DataSource dataDource;

    private SelectAllContacts selectAllContacts;

    private SelectContactByFirstName selectContactByFirstName;
    
    private UpdateContact updateContact;
    
    private InsertContact insertContact;
    
    private InsertContactTelDetail insertContactTelDetail;

    @Resource(name = "dataSource")
    public void setDataDource(DataSource dataDource) {
        this.dataDource = dataDource;

        selectAllContacts = new SelectAllContacts(dataDource);
        selectContactByFirstName = new SelectContactByFirstName(dataDource);
        updateContact = new UpdateContact(dataDource);
        insertContact = new InsertContact(dataDource);
    }

    public DataSource getDataDource() {
        return dataDource;
    }

    @Override
    public List<Contact> findAll() {
        return selectAllContacts.execute();
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("first_name", firstName);
        return selectContactByFirstName.executeByNamedParam(paramMap);
    }
    
    @Override
    public void update(Contact contact) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("first_name", contact.getFirstName());
        map.put("last_name", contact.getLastName());
        map.put("birth_date", contact.getBirthDate());
        map.put("contact_id", contact.getId());
        updateContact.updateByNamedParam(map);
        log.info("Existing contact update with id: " + contact.getId());
    }
    
    
    @Override
    public void insert(Contact contact) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("first_name", contact.getFirstName());
        map.put("last_name", contact.getLastName());
        map.put("birth_date", contact.getBirthDate());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertContact.updateByNamedParam(map, keyHolder);
        contact.setId(keyHolder.getKey().intValue());
        log.info("Insert ID: " + contact.getId());
    }
    
    
    @Override
    public void insertWithDetail(Contact contact) {
        insertContactTelDetail = new InsertContactTelDetail(dataDource);
        
        // add content
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("first_name", contact.getFirstName());
        map.put("last_name", contact.getLastName());
        map.put("birth_date", contact.getBirthDate());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertContact.updateByNamedParam(map, keyHolder);
        contact.setId(keyHolder.getKey().intValue());
        log.info("NEW CONTACT INSERTED WITH ID: " + contact.getId());
        
        // Batch insert
        List<ContactTelDetail> contactTelDetails =
                contact.getContactTelDetails();
        if(contactTelDetails != null) {
            for(ContactTelDetail contactTelDetail: contactTelDetails) {
                map = new HashMap<String, Object>();
                map.put("contact_id", contact.getId());
                map.put("tel_type", contactTelDetail.getTelType());
                map.put("tel_number", contactTelDetail.getTelNumber());
                insertContactTelDetail.updateByNamedParam(map);
            }
        }
        insertContactTelDetail.flush();
    }
    
    @Override
    public List<Contact> findAllWithDetail() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataDource());
        String sql = "select c.contact_id, c.first_name, c.last_name, c.birth_date, "
                + "t.contact_tel_detail_id, t.tel_type, t.tel_number from contact c "
                + "left join contact_tel_detail t on c.contact_id = t.contact_id";
        
        return jdbcTemplate.query(sql, new ContactWithDetailExtractor());
    }

    @Override
    public String findFirsNameById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String findLastNameById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int contactId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        private static final class ContactWithDetailExtractor implements ResultSetExtractor<List<Contact>> {
    
        public List<Contact> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Integer, Contact> map = new HashMap<Integer, Contact>();
            
            Contact contact = null;
            
            while(rs.next()) {
                int id = rs.getInt("contact_id");
                contact = map.get(id);
                if(contact == null) { // new entry
                    contact = new Contact();
                    contact.setId(rs.getInt("contact_id"));
                    contact.setFirstName(rs.getString("first_name"));
                    contact.setLastName(rs.getString("last_name"));
                    contact.setBirthDate(rs.getDate("birth_date"));
                    contact.setContactTelDetails(new ArrayList<ContactTelDetail>());
                    map.put(id, contact);
                }
                int contactTelDetailId = rs.getInt("contact_tel_detail_id");
                if(contactTelDetailId > 0) {
                    ContactTelDetail contactTelDetail = new ContactTelDetail();
                    contactTelDetail.setId(contactTelDetailId);
                    contactTelDetail.setContactId(id);
                    contactTelDetail.setTelType(rs.getString("tel_type"));
                    contactTelDetail.setTelNumber(rs.getString("tel_number"));
                    contact.getContactTelDetails().add(contactTelDetail);
                }
            }
            return new ArrayList<Contact>(map.values());
        }
    }
}
