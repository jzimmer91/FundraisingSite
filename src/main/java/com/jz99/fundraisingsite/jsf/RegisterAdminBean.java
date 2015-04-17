/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.jsf;

import com.jz99.fundraisingsite.ejb.RegisterService;
import java.util.Objects;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Joe
 */
@Named
@RequestScoped
public class RegisterAdminBean {
    
    @EJB
    RegisterService service;
    UIComponent usernameInput;
    String username;
    String password;
    
    public RegisterAdminBean(){
        
    }

    public String submitAdmin(){
       if(service.registerAdmin(username, password)){
         return "index";  
       }
       else{
           FacesMessage message = new FacesMessage("username already registered");
           FacesContext context = FacesContext.getCurrentInstance();
           context.addMessage(usernameInput.getClientId(context), message);
           return null;
       }
    }
    
    public RegisterService getService() {
        return service;
    }

    public void setService(RegisterService service) {
        this.service = service;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.service);
        hash = 97 * hash + Objects.hashCode(this.username);
        hash = 97 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegisterAdminBean other = (RegisterAdminBean) obj;
        if (!Objects.equals(this.service, other.service)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }
    
}
