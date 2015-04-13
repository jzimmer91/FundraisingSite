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
import javax.ejb.Startup;
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
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String passwd = password;
            md.update(passwd.getBytes("UTF-8"));
            byte[] digest = md.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            String storePass = bigInt.toString(16);
      
            UserAccount account = new UserAccount(firstName,lastName,email,address,aboutYou);
            SystemUser systemuser = new SystemUser(username, storePass, account);
            SystemUserGroup group = new SystemUserGroup(username,"user");
            em.persist(account);
            em.persist(systemuser);
            em.persist(group);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(RegisterServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  public void registerCharity(String username, String password, String charityName, String charityId, Date date,String address, String information){
      CharityAccount account = new CharityAccount(charityName,charityId,date,address,information);
      SystemUser systemuser = new SystemUser(username,password,account);
      SystemUserGroup group = new SystemUserGroup(username,"charity");
      em.persist(account);
      em.persist(systemuser);
      em.persist(group);
  }
  public void registerAdmin(String username, String password){
      AdminAccount account = new AdminAccount();
      SystemUser systemuser = new SystemUser(username,password, account);
      SystemUserGroup group = new SystemUserGroup(username,"admin");
      em.persist(account);
      em.persist(systemuser);
      em.persist(group);
      
  }
}
