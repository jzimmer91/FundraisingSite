/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.ejb;

import com.jz99.fundraisingsite.jpa.Activity;
import com.jz99.fundraisingsite.jpa.Cause;
import com.jz99.fundraisingsite.jpa.Donation;
import com.jz99.fundraisingsite.jpa.UserAccount;
import com.jz99.fundraisingsite.jpa.VirtualAccount;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.jz99.fundraisingsite.utils.Utils;

/**
 *
 * @author Joe
 */
@Stateless
public class DonationService {
    @PersistenceContext
    EntityManager em;
    
    public void registerCauseDonation(String causename, String amount){
        Cause cause = getCauseSelected(causename);
        VirtualAccount bank = getBank(causename);
        Donation donation = new Donation(cause, amount, getCurrentUser(),bank);
        em.persist(donation);
        em.flush();
    }
    
    public void registerActivityDonation(String causename, String activityname, String amount){
        Cause cause = getCauseSelected(causename);
        VirtualAccount bank = getBank(causename);
        Activity activity = getActivity(activityname);
        Donation donation = new Donation(cause,activity, amount,getCurrentUser(),bank);
        em.persist(donation);
        em.flush();
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
    
    public VirtualAccount getBank(String cause){
        Query query = em.createNamedQuery("findBank");
        query.setParameter("name", cause);
        List<VirtualAccount> bank = query.getResultList();
        return bank.get(0);
    }
    public Activity getActivity(String activityname){
        Query query = em.createNamedQuery("getActivity");
        query.setParameter("name", activityname);
        List<Activity> activity = query.getResultList();
        return activity.get(0);
    }
}
