/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch5.lifecycle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author vitaliy
 */
public class DestructiveBean implements InitializingBean {

    private InputStream is = null;
    
    public String filePath = null;
    
    @Override
    public void afterPropertiesSet() throws Exception {
    
        System.out.println("Initializing Bean");
        
        if(filePath == null) {
            throw new IllegalArgumentException("You must specify the filePath "
                    + "property of " + DestructiveBean.class);
        }
        
        is = new FileInputStream(filePath);
    }
    
    public void destroy() {
        System.out.println("Destroying Bean");
        
        if(is != null) {
            try {
                System.out.println(is.read());
                is.close();
                is= null;
            } catch(IOException ex) {
                System.out.println("WARN: An IOException occured trying "
                        + "to close the InputStream");
            }
        }
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:lifecycle/disposeMethod.xml");
        ctx.refresh();
        
        DestructiveBean bean = (DestructiveBean) ctx.getBean("destructiveBean");
        System.out.println("Calling destroy()");
        ctx.destroy();
        System.out.println("Called destroy()");
    }
}
