/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.ejb;

import com.jz99.fundraisingsite.jpa.*;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Joe
 */
@Stateless
public class RegisterServiceBean {
  @PersistenceContext
  EntityManager em; 
  
  //check for duplicate usernames before persisting
  public void registerUser(String username, String password, String firstName, String lastName, String email, String address, String aboutYou) {
        //User user = new User(username,password,firstName,lastName,email,address,aboutYou);
        UserAccount account = new UserAccount(firstName,lastName,email,address,aboutYou);
        SystemUser systemuser = new SystemUser(username,password, account);
        SystemUserGroup group = new SystemUserGroup(systemuser,"user");
        em.persist(account);
        em.persist(systemuser);
        em.persist(group);
    }
  public void registerCharity(String username, String password, String charityName, String charityId, Date date,String address, String information){
      CharityAccount account = new CharityAccount(charityName,charityId,date,address,information);
      SystemUser systemuser = new SystemUser(username,password,account);
      SystemUserGroup group = new SystemUserGroup(systemuser,"charity");
      em.persist(account);
      em.persist(systemuser);
      em.persist(group);
  }
  public void registerAdmin(String username, String password){
      AdminAccount account = new AdminAccount();
      SystemUser systemuser = new SystemUser(username,password, account);
      SystemUserGroup group = new SystemUserGroup(systemuser,"admin");
      em.persist(account);
      em.persist(systemuser);
      em.persist(group);
      
  }
}
