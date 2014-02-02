/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch4;

/**
 *
 * @author vitaliy
 */
public interface ArtworkSender {

   public void sendArtwork(String artworkPath, Recipient recipient);
   
   public String getFriendlyName();
   
   public String getShortName();
}
