/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.jpa;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Joe
 */
@Entity
@NamedQueries({
        @NamedQuery(name="byActivity", query="SELECT d FROM Donation d WHERE d.activity.name = LOWER(:activityname)"),
        @NamedQuery(name="byCause", query="SELECT d FROM Donation d WHERE d.cause.name = LOWER(:causename)")        
})
public class Donation implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull @ManyToOne
    private Cause cause;
    @ManyToOne
    private Activity activity;
    @NotNull
    private int amount;
    @NotNull    @ManyToOne
    private UserAccount donor;
    @NotNull @ManyToOne
    private CharityAccount charity;
    
    public Donation(){
        
    }
    //Activity donation
    public Donation(Cause cause, Activity activity, int amount, UserAccount donor, CharityAccount charity){
        this.cause = cause;
        this.activity = activity;
        this.amount = amount;
        this.donor = donor;
        this.charity = charity;
    }
    
    public Donation(Cause cause, int amount, UserAccount user, CharityAccount charity){
        this.cause = cause;
        this.amount = amount;
        this.charity = charity;
    }
  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cause getCause() {
        return cause;
    }

    public void setCause(Cause cause) {
        this.cause = cause;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public UserAccount getDonor() {
        return donor;
    }

    public void setDonor(UserAccount donor) {
        this.donor = donor;
    }

    public CharityAccount getCharity() {
        return charity;
    }

    public void setCharity(CharityAccount charity) {
        this.charity = charity;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.cause);
        hash = 67 * hash + Objects.hashCode(this.activity);
        hash = 67 * hash + Objects.hashCode(this.amount);
        hash = 67 * hash + Objects.hashCode(this.donor);
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
        final Donation other = (Donation) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cause, other.cause)) {
            return false;
        }
        if (!Objects.equals(this.activity, other.activity)) {
            return false;
        }
        if (!Objects.equals(this.amount,other.amount)) {
            return false;
        }
        if (!Objects.equals(this.donor, other.donor)) {
            return false;
        }
        return true;
    }

    
    
    
}
