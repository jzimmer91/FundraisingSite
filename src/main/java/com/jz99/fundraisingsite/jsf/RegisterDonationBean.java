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
    String cause;
    String activity;
    int amount;
    
    public RegisterDonationBean(){
        
    }
    
    public void submitCauseDonation(){
        service.registerCauseDonation(cause,amount);
    }
    
    public void submitActivityDonation(){
        service.registerActivityDonation(cause,activity,amount);
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.cause);
        hash = 89 * hash + Objects.hashCode(this.activity);
        hash = 89 * hash + this.amount;
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
        if (this.amount != other.amount) {
            return false;
        }
        return true;
    }
    
    
}
