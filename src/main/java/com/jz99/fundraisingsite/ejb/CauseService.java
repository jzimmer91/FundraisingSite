/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.ejb;

import com.jz99.fundraisingsite.jpa.Cause;
import com.jz99.fundraisingsite.jpa.CharityAccount;
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
public class CauseService {
    @PersistenceContext
    EntityManager em;
    
    public void registerCause(String name, String info){
        //change null to current charity
        Cause cause = new Cause(name, info, getCurrentUser());
        em.persist(cause);
        
    }
    public CharityAccount getCurrentUser(){
        String currentUser = Utils.getCurrentUser();
        Query query = em.createNamedQuery("getAccount");
        query.setParameter("username", currentUser);
        List<CharityAccount> users = query.getResultList();
        return users.get(0);
    }
}
