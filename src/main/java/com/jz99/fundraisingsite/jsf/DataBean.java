/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.jsf;

import com.jz99.fundraisingsite.ejb.DataService;
import com.jz99.fundraisingsite.jpa.*;
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
public class DataBean {
    
    List<UserAccount> users;
    List<CharityAccount> charities;
    
    
    @EJB
    DataService service;
    
    @PostConstruct
    private void init(){
        this.users = service.getUsers();
        this.charities = service.getCharities();
    }   
    
    public List<UserAccount> getUsers() {
        return users;
    }

    public void setUsers(List<UserAccount> users) {
        this.users = users;
    }

    public List<CharityAccount> getCharities() {
        return charities;
    }

    public void setCharities(List<CharityAccount> charities) {
        this.charities = charities;
    }

    public DataService getService() {
        return service;
    }

    public void setService(DataService service) {
        this.service = service;
    }
    
    
}
