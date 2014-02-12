/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.ln_spring.ch4.mi;

import java.lang.reflect.Method;
import org.springframework.beans.factory.support.MethodReplacer;

/**
 *
 * @author vitaliy
 */
public class FormatMessageReplacer implements MethodReplacer {
    
    public Object reimplement(Object arg0, Method method, Object[] args) {
    
        if(isFormatMessageMethod(method)) {
            String msg = (String) args[0];
            
            return "<h2>" + msg + "</h2>";
        } else {
            throw  new IllegalArgumentException("Unable to reimplement method " 
                    + method.getName());
        }
        
    }
    
    private boolean isFormatMessageMethod(Method method) {
        // Проверить правильность количества параметров
        if(method.getParameterTypes().length != 1) {
            return  false;
        }
        
        // Проаерить имя метода
        if(!("formatMessage".equals(method.getName()))) {
            return false;
        }
        
        // Проверить возвращаемый тип
        if(method.getReturnType() != String.class) {
            return false;
        }
        
        // Проверить тип параметра
        if(method.getParameterTypes()[0] != String.class) {
            return false;
        }
        
        return true;
    }
}
