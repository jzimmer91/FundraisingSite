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

/**
 *
 * @author Joe
 */
@Stateless
public class ListService {
    @PersistenceContext
    EntityManager em;
    
    public List<CharityAccount> getCharities(){
        List<CharityAccount> charities = em.createNamedQuery("listCharities").getResultList();
        return charities;
    }
    
    public List<UserAccount> getUsers(){
        List<UserAccount> users = em.createNamedQuery("listCharities").getResultList();
        return users;
    }
}
