/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch8.domain;

import java.io.Serializable;

/**
 *
 * @author vitaliy
 */
public class ContactTelDetail implements Serializable {
    
    private int id;
    
    private int contactId;
    
    private String telType;
    
    private String telNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getTelType() {
        return telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        return "ContactTelDetail{" + "id=" + id + ", contactId=" + contactId + ", telType=" + telType + ", telNumber=" + telNumber + '}';
    }

}
