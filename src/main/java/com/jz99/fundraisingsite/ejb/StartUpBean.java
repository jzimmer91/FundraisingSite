/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.ejb;


import com.jz99.fundraisingsite.jpa.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utils.Utils;

/**
 *
 * @author Joe
 */

@Startup
@Singleton
public class StartUpBean {
  
  @PersistenceContext
  EntityManager em;
  
  public StartUpBean(){
      
  }
  @PostConstruct
  public void PostConstruct(){
      
        
      String pass = Utils.PasswordEncrypt("admin1");
      AdminAccount admin = new AdminAccount("admin1");
      SystemUser user = new SystemUser("admin1", pass, admin);
      SystemUserGroup group = new SystemUserGroup("admin1", "admin");
      em.persist(admin);
      em.persist(user);
      em.persist(group);
      em.flush();
      
  }
}
