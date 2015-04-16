/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.ejb;

import com.jz99.fundraisingsite.jpa.Donation;
import com.jz99.fundraisingsite.jpa.UserAccount;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utils.Utils;

/**
 *
 * @author Joe
 */
@Stateless
public class DonationService {
    @PersistenceContext
    EntityManager em;
    
    public void registerCauseDonation(String cause, int amount){
        Donation donation = new Donation(null, amount, getCurrentUser());
        em.persist(donation);
        em.flush();
    }
    
    public void registerActivityDonation(String cause, String activity, int amount){
        Donation donation = new Donation(null,null, amount,getCurrentUser());
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
}
