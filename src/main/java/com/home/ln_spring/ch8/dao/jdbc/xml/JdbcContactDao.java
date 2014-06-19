/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch8.dao.jdbc.xml;

import com.home.ln_spring.ch8.dao.ContactDao;
import com.home.ln_spring.ch8.domain.Contact;
import com.home.ln_spring.ch8.domain.ContactTelDetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 *
 * @author vitaliy
 */
public class JdbcContactDao implements ContactDao, InitializingBean {
    
    private JdbcTemplate jdbcTemplate;
   
    private DataSource dataSource;
    
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DataSource getDataSource() {
        return dataSource;
    }
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        
    }


    @Override
    public String findFirsNameById(int id) {
        String firstName = jdbcTemplate.queryForObject(
        "select first_name from contact where contact_id = ?", 
                new Object[]{id}, String.class);
        return firstName;
    }
    
    
    @Override
    public String findLastNameById(int id) {
        String sql = "select last_name from contact where contact_id = :contactId";
        
//        SqlParameterSource nameParameters =
//                new MapSqlParameterSource("contactId", id);
        
        Map<String, Object> nameParameters = new HashMap<String, Object>();
        nameParameters.put("contactId", id);
        
        return namedParameterJdbcTemplate.queryForObject(sql, nameParameters, String.class);
    }

    @Override
    public List<Contact> findAll() {
        String sql = "select * from contact";
        return jdbcTemplate.query(sql, new ContactMapper());
    }
    
    @Override
    public List<Contact> findAllWithDetail() {
        String sql = "select c.contact_id, c.first_name, c.last_name, c.birth_date, "
                + "t.contact_tel_detail_id, t.tel_type, t.tel_number from contact c "
                + "left join contact_tel_detail t on c.contact_id = t.contact_id";
        
        return jdbcTemplate.query(sql, new ContactWithDetailExtractor());
    }

    @Override
    public void insert(Contact contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Contact contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int contactId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException("Must set dataSource on ContactDao");
        }
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertWithDetail(Contact contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class ContactMapper implements RowMapper<Contact> {
        
        public Contact mapRow(ResultSet rs, int i) throws SQLException {
            Contact contact = new Contact();
            
            contact.setId(rs.getInt("contact_id"));
            contact.setFirstName(rs.getString("first_name"));
            contact.setLastName(rs.getString("last_name"));
            contact.setBirthDate(rs.getDate("birth_date"));
            return contact;
        }
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
