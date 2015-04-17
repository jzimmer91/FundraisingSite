/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.ejb;

import com.jz99.fundraisingsite.jpa.Activity;
import com.jz99.fundraisingsite.jpa.Cause;
import com.jz99.fundraisingsite.jpa.CharityAccount;
import com.jz99.fundraisingsite.jpa.Donation;
import com.jz99.fundraisingsite.jpa.UserAccount;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.jz99.fundraisingsite.utils.Utils;
import javax.annotation.security.RolesAllowed;

/**
 *
 * @author Joe
 */
@Stateless
public class DonationService {
    @PersistenceContext
    EntityManager em;
    
    @RolesAllowed("user")
    public boolean registerCauseDonation(String causename, int amount){
        UserAccount user = getCurrentUser();
        int balance = user.getBalance();
        if (balance >= amount){
            Cause cause = getCauseSelected(causename);
            CharityAccount charity = getCharity(causename);
        
            Donation donation = new Donation(cause, amount, user,charity);
            em.persist(donation);
            em.flush();  
            //POST TO INCR
            
            return true;
        }
        else{
            return false;
        }
        
    }
    @RolesAllowed("user")
    public boolean registerActivityDonation(String causename, String activityname, int amount){
        UserAccount user = getCurrentUser();
        int balance = user.getBalance();
        if (balance >= amount){
            
            Cause cause = getCauseSelected(causename);
            CharityAccount charity = getCharity(causename);
            Activity activity = getActivity(activityname);        
            Donation donation = new Donation(cause,activity, amount,user,charity);
            em.persist(donation);
            em.flush();
            //POST TO INCR
            return true;
        }
        else{        
            return false;
        }        
    }
    public UserAccount getCurrentUser(){
        String currentUser = Utils.getCurrentUser();
        Query query = em.createNamedQuery("getAccount");
        query.setParameter("username", currentUser);
        List<UserAccount> users = query.getResultList();
        return users.get(0);
    }
    public Cause getCauseSelected(String cause){
        Query query = em.createNamedQuery("selectCause");
        query.setParameter("name", cause);
        List<Cause> selectedcause = query.getResultList();
        return selectedcause.get(0);        
    }
    
    public CharityAccount getCharity(String cause){
        Query query = em.createNamedQuery("findCharity");
        query.setParameter("name", cause);
        List<CharityAccount> charity = query.getResultList();
        return charity.get(0);
    }
    public Activity getActivity(String activityname){
        Query query = em.createNamedQuery("getActivity");
        query.setParameter("name", activityname);
        List<Activity> activity = query.getResultList();
        return activity.get(0);
    }
}
