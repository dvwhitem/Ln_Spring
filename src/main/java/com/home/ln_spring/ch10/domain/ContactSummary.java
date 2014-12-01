/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch10.domain;

import java.io.Serializable;

/**
 *
 * @author vitaliy
 */
public class ContactSummary implements Serializable {
    
    private String firstName;
    
    private String lastName;
    
    private String homeTelNumber;
    
    public ContactSummary(String firstName, String lastName, String hometelNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeTelNumber = hometelNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomeTelNumber() {
        return homeTelNumber;
    }

    public void setHomeTelNumber(String homeTelNumber) {
        this.homeTelNumber = homeTelNumber;
    }

    @Override
    public String toString() {
        return "ContactSummary{" + "firstName=" + firstName + ", lastName=" + lastName + ", homeTelNumber=" + homeTelNumber + '}';
    }
}
