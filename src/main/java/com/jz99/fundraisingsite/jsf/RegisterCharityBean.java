/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.jsf;

import com.jz99.fundraisingsite.ejb.RegisterService;
import java.util.Date;
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
public class RegisterCharityBean {
    
   @EJB
   RegisterService service;
   UIComponent emailInput; 
   String email;
   String password;
   String charityName;
   String charityId;
   Date date;
   String address;
   String information;
   
   public RegisterCharityBean(){
       
   }
   
   public String submitCharity(){
       if (service.registerCharity(email, password, charityName, charityId,date,address,information)){
            return "index";
       }
       else
       {
           FacesMessage message = new FacesMessage("Email already registered");
           FacesContext context = FacesContext.getCurrentInstance();
           context.addMessage(emailInput.getClientId(context), message);
           return null;
       }
   }

    public RegisterService getService() {
        return service;
    }

    public void setService(RegisterService service) {
        this.service = service;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCharityName() {
        return charityName;
    }

    public void setCharityName(String charityName) {
        this.charityName = charityName;
    }

    public String getCharityId() {
        return charityId;
    }

    public void setCharityId(String charityId) {
        this.charityId = charityId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public UIComponent getEmailInput() {
        return emailInput;
    }

    public void setEmailInput(UIComponent emailInput) {
        this.emailInput = emailInput;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.service);
        hash = 13 * hash + Objects.hashCode(this.email);
        hash = 13 * hash + Objects.hashCode(this.password);
        hash = 13 * hash + Objects.hashCode(this.charityName);
        hash = 13 * hash + Objects.hashCode(this.charityId);
        hash = 13 * hash + Objects.hashCode(this.date);
        hash = 13 * hash + Objects.hashCode(this.address);
        hash = 13 * hash + Objects.hashCode(this.information);
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
        final RegisterCharityBean other = (RegisterCharityBean) obj;
        if (!Objects.equals(this.service, other.service)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.charityName, other.charityName)) {
            return false;
        }
        if (!Objects.equals(this.charityId, other.charityId)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.information, other.information)) {
            return false;
        }
        return true;
    }
   
}
