/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch8.dao.plain;

import com.home.ln_spring.ch8.dao.ContactDao;
import com.home.ln_spring.ch8.domain.Contact;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitaliy
 */
public class PlainContactDao implements ContactDao {
    
    static {
        try {
            Class.forName("com.postgresql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            
        }
    }
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/spring3ch8",
                "vitaliy", "qwerty");
    }
    
    private void closeConnection(Connection connection) {
        if(connection == null) return;
        
        try {
            connection.close();
        } catch(SQLException ex) {
            
        }
    }

    @Override
    public List<Contact> findAll() {

        List<Contact> result = new ArrayList<Contact>();

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = 
                    connection.prepareStatement("select * from contact");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Contact contact = new Contact();
                contact.setId(resultSet.getInt("contact_id"));
                contact.setFirstName(resultSet.getString("first_name"));
                contact.setLastName(resultSet.getString("last_name"));
                contact.setBirthDate(resultSet.getDate("birth_date"));
                result.add(contact);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }

        return result;
    }

    @Override
    public void insert(Contact contact) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "insert into contact (contact_id, first_name, last_name, birth_date) "
                            + "values (DEFAULT, ?, ?, ?)", 
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, contact.getFirstName());
            statement.setString(2, contact.getLastName());
            statement.setDate(3, (Date) contact.getBirthDate());
            statement.execute();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                contact.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Contact contact) {
        
    }

    @Override
    public void delete(int contactId) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = 
                    connection.prepareStatement("delete from contact where contact_id=?");
            statement.setInt(1, contactId);
            statement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public String findFirsNameById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String findLastNameById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contact> findAllWithDetail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertWithDetail(Contact contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
