/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Joe
 */
@Entity
@NamedQueries({
    @NamedQuery(name="listUsers", query="SELECT u FROM UserAccount u ORDER BY u.lastName"),    
    @NamedQuery(name="getUser", query="SELECT u FROM UserAccount u WHERE u.accountId = (:id)")
})

@XmlRootElement
public class UserAccount extends Account implements Serializable {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String address;
    @NotNull
    private String aboutYou;
    @NotNull
    private int balance;
    @OneToMany(mappedBy="fundraiser")
    private List<Activity> activities;
    
    public UserAccount(){
        
    }
    public UserAccount(String firstName, String lastName, String address, String aboutYou) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.aboutYou = aboutYou;
        this.balance = 10000;
        this.activities = new ArrayList<>();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAboutYou() {
        return aboutYou;
    }

    public void setAboutYou(String aboutYou) {
        this.aboutYou = aboutYou;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @XmlTransient
    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.firstName);
        hash = 61 * hash + Objects.hashCode(this.lastName);
        hash = 61 * hash + Objects.hashCode(this.address);
        hash = 61 * hash + Objects.hashCode(this.aboutYou);
        hash = 61 * hash + this.balance;
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
        final UserAccount other = (UserAccount) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.aboutYou, other.aboutYou)) {
            return false;
        }
        if (this.balance != other.balance) {
            return false;
        }
        return true;
    }

   
    
}
