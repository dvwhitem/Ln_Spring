/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch4.mi;

/**
 *
 * @author vitaliy
 */
public class ReplacementTarget {

    public String formatMessage(String msg) {
        return "<h4>" + msg + "</h4>";
    }
    
    public String formatMessage(Object msg) {
        return "<h5>" + msg + "</h5>";
    }
}
