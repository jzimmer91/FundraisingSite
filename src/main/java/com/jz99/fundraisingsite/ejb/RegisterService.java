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
import utils.Utils;

/**
 *
 * @author Joe
 */

@Stateless
public class RegisterService {
  @PersistenceContext
  EntityManager em; 
  
  
  //check for duplicate emails before persisting
  public void registerUser(String email, String password, String firstName, String lastName, String address, String aboutYou) {
               
            String pass = Utils.PasswordEncrypt(password);
            
            UserAccount account = new UserAccount(email,firstName,lastName,address,aboutYou);
            SystemUser systemuser = new SystemUser(email, pass, account);
            SystemUserGroup group = new SystemUserGroup(email,"user");
            em.persist(account);
            em.persist(systemuser);
            em.persist(group);
        
    }
  //check for duplicate emails before persisting
  public void registerCharity(String email, String password, String charityName, String charityId, Date date,String address, String information){
      
      String pass = Utils.PasswordEncrypt(password);
      
      CharityAccount account = new CharityAccount(email,charityName,charityId,date,address,information);
      SystemUser systemuser = new SystemUser(email,pass,account);
      SystemUserGroup group = new SystemUserGroup(email,"charity");
      em.persist(account);
      em.persist(systemuser);
      em.persist(group);
  }
  public void registerAdmin(String username, String password){      
      String pass = Utils.PasswordEncrypt(password);
      
      AdminAccount account = new AdminAccount(username);
      SystemUser systemuser = new SystemUser(username,pass, account);
      SystemUserGroup group = new SystemUserGroup(username,"admin");
      em.persist(account);
      em.persist(systemuser);
      em.persist(group);
      
      
  }
}
