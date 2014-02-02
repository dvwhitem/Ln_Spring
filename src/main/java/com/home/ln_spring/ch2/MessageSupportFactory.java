/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch2;

import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author vitaliy
 */
public class MessageSupportFactory {

    private static MessageSupportFactory instance = null;
    private Properties props = null;
    private MessageRenderer renderer = null;
    private MessageProvider provider = null;
    
    private MessageSupportFactory() {
        props = new Properties();
        
        try {
            props.load(new FileInputStream("src/conf/msf.properties"));
            // Получить классы реализации
            String rendererClass = props.getProperty("renderer.class");
            String providerClass = props.getProperty("provider.class");
            renderer = 
                    (MessageRenderer) Class.forName(rendererClass).newInstance();
            provider =
                    (MessageProvider) Class.forName(providerClass).newInstance();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRenderer getRenderer() {
        return renderer;
    }

    public MessageProvider getProvider() {
        return provider;
    }
}
