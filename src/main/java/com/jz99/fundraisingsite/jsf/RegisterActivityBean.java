/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.jsf;

import com.jz99.fundraisingsite.ejb.ActivityService;
import com.jz99.fundraisingsite.jpa.Cause;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Joe
 */
@Named
@RequestScoped
public class RegisterActivityBean {
    
    @EJB
    ActivityService service;
    
    String name;
    String info;
    String cause;
    List<Cause> causes;
    
    public RegisterActivityBean(){        
    }
    
    @PostConstruct
    private void init(){
        this.causes = service.getCauses();
    }
    
    public String submitActivity(){
        service.registerActivity(name,info);
        return "index";
    }

    public ActivityService getService() {
        return service;
    }

    public void setService(ActivityService service) {
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
    
    public List<Cause> getCauses() {
        return causes;
    }

    public void setCauses(List<Cause> causes) {
        this.causes = causes;
    }
    
}
