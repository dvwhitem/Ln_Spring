/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch8.dao.jdbc.annotation;

import com.home.ln_spring.ch8.domain.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.sql.DataSource;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

/**
 *
 * @author vitaliy
 */
public class SelectContactByFirstName extends MappingSqlQuery<Contact> {
    
    private static final String SQL_FIND_BY_FIRST_NAME =
            "select * from contact where first_name = :first_name";
    
    public SelectContactByFirstName(DataSource dataSource) {
        super(dataSource, SQL_FIND_BY_FIRST_NAME);
        super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
    }

    @Override
    protected Contact mapRow(ResultSet rs, int i) throws SQLException {
        Contact contact = new Contact();

        contact.setId(rs.getInt("contact_id"));
        contact.setFirstName(rs.getString("first_name"));
        contact.setLastName(rs.getString("last_name"));
        contact.setBirthDate(rs.getDate("birth_date"));

        return contact;
    }
}
