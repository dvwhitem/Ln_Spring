/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.env;

/**
 *
 * @author vitaliy
 */
public class AppProperty {
    
    private String applicationHome;
    
    private String userHome;

    public String getApplicationHome() {
        return applicationHome;
    }

    public void setApplicationHome(String applicationHome) {
        this.applicationHome = applicationHome;
    }

    public String getUserHome() {
        return userHome;
    }

    public void setUserHome(String userHome) {
        this.userHome = userHome;
    }

    @Override
    public String toString() {
        return "AppProperty{" + "applicationHome=" + applicationHome + ", userHome=" + userHome + '}';
    }
}
