/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.ejb;

import com.jz99.fundraisingsite.jpa.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Joe
 */
@Stateless
public class DataService {
    @PersistenceContext
    EntityManager em;
    
    public List<CharityAccount> getCharities(){
        List<CharityAccount> charities = em.createNamedQuery("listCharities").getResultList();
        return charities;
    }
    
    public List<UserAccount> getUsers(){
        List<UserAccount> users = em.createNamedQuery("listUsers").getResultList();
        return users;
    }

    public UserAccount findUser(Long id) {
        Query query = em.createNamedQuery("getUser");
        query.setParameter("id", id);
        List<UserAccount> user = query.getResultList();
        if (user.isEmpty()){
            return null;
        }
        else{
            return user.get(0);
        } 
    }

    public CharityAccount findCharity(Long id) {
        Query query = em.createNamedQuery("getCharity");
        query.setParameter("id", id);
        List<CharityAccount> charity = query.getResultList();
        if (charity.isEmpty()){
            return null;
        }
        else{
            return charity.get(0);
        }
    }

    public Activity findActivity(Long id) {
        Query query = em.createNamedQuery("getActivity");
        query.setParameter("id", id);
        List<Activity> activity = query.getResultList();
        if (activity.isEmpty()){
            return null;
        }
        else{
            return activity.get(0);
        }       
    }

    public Cause findCause(Long id) {
        Query query = em.createNamedQuery("getCause");
        query.setParameter("id", id);
        List<Cause> cause = query.getResultList();
        if (cause.isEmpty()){
            return null;
        }
        else{
            return cause.get(0);
        }
    }
}
