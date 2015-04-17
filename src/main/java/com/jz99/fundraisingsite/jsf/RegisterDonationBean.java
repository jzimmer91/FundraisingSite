/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.jsf;

import com.jz99.fundraisingsite.ejb.DonationService;
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
public class RegisterDonationBean {
    
    @EJB
    DonationService service;
    UIComponent donationInput;
    String cause;
    String activity;
    int amount;
    
    public RegisterDonationBean(){
        
    }
    
    public void submitCauseDonation(){
        if(amount > 500){
           FacesMessage message = new FacesMessage("Donations can not be over £500");
           FacesContext context = FacesContext.getCurrentInstance();
           context.addMessage(donationInput.getClientId(context), message);
        }
        else{    
            if(service.registerCauseDonation(cause,amount)){
                FacesMessage message = new FacesMessage("Donation successful");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(donationInput.getClientId(context), message);
            }
            else{
                FacesMessage message = new FacesMessage("Insufficient funds");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(donationInput.getClientId(context), message);
            }
        }
    }
    
    public void submitActivityDonation(){        
        if( amount > 500){
           FacesMessage message = new FacesMessage("Donations can not be over £500");
           FacesContext context = FacesContext.getCurrentInstance();
           context.addMessage(donationInput.getClientId(context), message);
        }
        else{    
            if(service.registerActivityDonation(cause,activity,amount)){
                FacesMessage message = new FacesMessage("Donation successful");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(donationInput.getClientId(context), message);
            }
            else{
                FacesMessage message = new FacesMessage("Insufficient funds");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(donationInput.getClientId(context), message);
            }
        }        
    }

    
    
    public DonationService getService() {
        return service;
    }

    public void setService(DonationService service) {
        this.service = service;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public UIComponent getDonationInput() {
        return donationInput;
    }

    public void setDonationInput(UIComponent donationInput) {
        this.donationInput = donationInput;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.cause);
        hash = 89 * hash + Objects.hashCode(this.activity);
        hash = 89 * hash + Objects.hashCode(this.amount);
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
        final RegisterDonationBean other = (RegisterDonationBean) obj;
        if (!Objects.equals(this.cause, other.cause)) {
            return false;
        }
        if (!Objects.equals(this.activity, other.activity)) {
            return false;
        }
        if (!Objects.equals(this.amount, other.amount)) {
            return false;
        }
        return true;
    }

    
    
    
}
