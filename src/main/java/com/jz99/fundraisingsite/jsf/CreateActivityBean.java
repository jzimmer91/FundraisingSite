/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.jsf;

import com.jz99.fundraisingsite.ejb.TempService;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Joe
 */
@Named
@RequestScoped
public class CreateActivityBean {
    
    @EJB
    TempService service;
    
    String name;
    String info;
    String cause;
    
    public CreateActivityBean(){
        
    }
    
    public void submitActivity(){
        
    }

    public TempService getService() {
        return service;
    }

    public void setService(TempService service) {
        this.service = service;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
    
}
