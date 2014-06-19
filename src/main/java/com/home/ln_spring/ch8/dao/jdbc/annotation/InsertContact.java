/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.ln_spring.ch8.dao.jdbc.annotation;

import java.sql.Types;
import javax.sql.DataSource;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

/**
 *
 * @author vitaliy
 */
public class InsertContact extends SqlUpdate {

    private static final String SQL_INSERT_CONTACT = 
            "insert into contact(contact_id, first_name, last_name, birth_date) "
            + "values(DEFAULT, :first_name, :last_name, :birth_date)";
    
    public InsertContact(DataSource dataSource) {
        super(dataSource, SQL_INSERT_CONTACT);
        super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("last_name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("birth_date", Types.DATE));
        super.setGeneratedKeysColumnNames(new String[] {"contact_id"});
        super.setReturnGeneratedKeys(true);
    }
}
