/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch8.dao.jdbc.annotation;

import com.home.ln_spring.ch8.dao.ContactSfDao;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vitaliy
 */
@Repository("contactSfDao")
public class JdbcContactSfDao implements ContactSfDao {
    
    private DataSource dataSource;
    
    private SfFirstNameById sfFirstNameById;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Resource(name="dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        
        sfFirstNameById = new SfFirstNameById(dataSource);
    }

    @Override
    public String getFirstNameById(int id) {
        List<String> result = sfFirstNameById.execute(id);
        return result.get(0);
    }
    
}
