/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Joe
 */
@Entity
public class CharityAccount extends Account implements Serializable{
   @NotNull
   private String charityName;
   @NotNull
   private String charityId;   
   @NotNull @Temporal(javax.persistence.TemporalType.DATE)
   private Date establishmentDate;
   @NotNull
   private String address;
   @NotNull
   private String information;
   @OneToMany(mappedBy="charity")
   private List<Cause> causes;
   private int balance;
   
   
   public CharityAccount(){
       
   }
   
   public CharityAccount(String charityName, String charityId, Date establishmentDate, String address, String information) {
        this.charityName = charityName;
        this.charityId = charityId;
        this.establishmentDate = establishmentDate;
        this.address = address;
        this.information = information;
        this.causes = new ArrayList<Cause>();
        this.balance = 0;
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

    public Date getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(Date establishmentDate) {
        this.establishmentDate = establishmentDate;
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

    public List<Cause> getCauses() {
        return causes;
    }

    public void setCauses(List<Cause> causes) {
        this.causes = causes;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.getAccountId());
        hash = 97 * hash + Objects.hashCode(this.charityName);
        hash = 97 * hash + Objects.hashCode(this.charityId);
        hash = 97 * hash + Objects.hashCode(this.establishmentDate);
        hash = 97 * hash + Objects.hashCode(this.address);
        hash = 97 * hash + Objects.hashCode(this.information);
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
        final CharityAccount other = (CharityAccount) obj;
        if (!Objects.equals(this.getAccountId(), other.getAccountId())) {
            return false;
        }
        if (!Objects.equals(this.charityName, other.charityName)) {
            return false;
        }
        if (!Objects.equals(this.charityId, other.charityId)) {
            return false;
        }
        if (!Objects.equals(this.establishmentDate, other.establishmentDate)) {
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
