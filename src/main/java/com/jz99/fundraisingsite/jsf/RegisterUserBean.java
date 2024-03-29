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
public class RegisterUserBean{
    @EJB
    RegisterService service; 
    UIComponent emailInput;
    String email;
    String password;
    String firstName;
    String lastName;    
    String address;
    String aboutYou;
    
    public RegisterUserBean(){
        
    }
    
    public String submitUser(){
        if(service.registerUser(email, password, firstName, lastName, address, aboutYou)){
            return "index";  
        }
        else{
           FacesMessage message = new FacesMessage("Email already registered");
           FacesContext context = FacesContext.getCurrentInstance();
           context.addMessage(emailInput.getClientId(context), message);
           return null;
        }
        
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public String getAboutYou() {
        return aboutYou;
    }

    public void setAboutYou(String aboutYou) {
        this.aboutYou = aboutYou;
    }

    public RegisterService getService() {
        return service;
    }

    public void setService(RegisterService service) {
        this.service = service;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        
        hash = 37 * hash + Objects.hashCode(this.password);
        hash = 37 * hash + Objects.hashCode(this.firstName);
        hash = 37 * hash + Objects.hashCode(this.lastName);
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + Objects.hashCode(this.address);
        hash = 37 * hash + Objects.hashCode(this.aboutYou);
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
        final RegisterUserBean other = (RegisterUserBean) obj;
        
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.aboutYou, other.aboutYou)) {
            return false;
        }
        return true;
    }
    
}
