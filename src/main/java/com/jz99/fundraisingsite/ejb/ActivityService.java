/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.ejb;

import com.jz99.fundraisingsite.jpa.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import utils.Utils;

/**
 *
 * @author Joe
 */
@Stateless
public class ActivityService {
    @PersistenceContext
    EntityManager em;
    
    public void registerActivity(String name, String info, String cause){
           
        //change first null to cause and second to current user
        Activity activity = new Activity(name, info, getCauseSelected(cause), getCurrentUser());
        em.persist(activity);
    }
    
    public Cause getCauseSelected(String cause){
        Query query = em.createNamedQuery("selectCause");
        query.setParameter("name", cause);
        List<Cause> selectedcause = query.getResultList();
        return selectedcause.get(0);
        
    }
    public List<Cause> getCauses(){
        List<Cause> causes = em.createNamedQuery("listCauses").getResultList();
        return causes;
    }
    public UserAccount getCurrentUser(){
        String currentUser = Utils.getCurrentUser();
        Query query = em.createNamedQuery("getAccount");
        query.setParameter("username", currentUser);
        List<UserAccount> users = query.getResultList();
        return users.get(0);
    }
}