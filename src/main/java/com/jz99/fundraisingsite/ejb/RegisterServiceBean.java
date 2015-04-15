/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.ejb;

import com.jz99.fundraisingsite.jpa.*;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utils.PasswordEncrypt;

/**
 *
 * @author Joe
 */

@Stateless
public class RegisterServiceBean {
  @PersistenceContext
  EntityManager em; 
  
  
  //check for duplicate emails before persisting
  public void registerUser(String email, String password, String firstName, String lastName, String address, String aboutYou) {
               
            String pass = PasswordEncrypt.Encrypt(password);
            
            UserAccount account = new UserAccount(firstName,lastName,address,aboutYou);
            SystemUser systemuser = new SystemUser(email, pass, account);
            SystemUserGroup group = new SystemUserGroup(email,"user");
            em.persist(account);
            em.persist(systemuser);
            em.persist(group);
        
    }
  //check for duplicate emails before persisting
  public void registerCharity(String email, String password, String charityName, String charityId, Date date,String address, String information){
      
      String pass = PasswordEncrypt.Encrypt(password);
      
      CharityAccount account = new CharityAccount(charityName,charityId,date,address,information);
      SystemUser systemuser = new SystemUser(email,pass,account);
      SystemUserGroup group = new SystemUserGroup(email,"charity");
      em.persist(account);
      em.persist(systemuser);
      em.persist(group);
  }
  public void registerAdmin(String username, String password){      
      String pass = PasswordEncrypt.Encrypt(password);
      
      AdminAccount account = new AdminAccount(username);
      SystemUser systemuser = new SystemUser(username,pass, account);
      SystemUserGroup group = new SystemUserGroup(username,"admin");
      em.persist(account);
      em.persist(systemuser);
      em.persist(group);
      
      
  }
}
