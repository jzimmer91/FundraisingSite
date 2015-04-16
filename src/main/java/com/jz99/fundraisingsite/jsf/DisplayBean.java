/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.jsf;

import com.jz99.fundraisingsite.ejb.DataService;
import com.jz99.fundraisingsite.jpa.Activity;
import com.jz99.fundraisingsite.jpa.Cause;
import com.jz99.fundraisingsite.jpa.CharityAccount;
import com.jz99.fundraisingsite.jpa.UserAccount;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Joe
 */
@Named
@ConversationScoped
public class DisplayBean implements Serializable {
    @EJB
    DataService service;
    @Inject
    Conversation conversation;
    
    UserAccount singleUser;
    CharityAccount singleCharity;
    Activity singleActivity;
    Cause singleCause;
    
    public void begin(){
        conversation.begin();
    }
    public void end(){
        conversation.end();
    }
    public String goHome(){
        end();
        return "/index.xhtml";
    }
    public String findUser(String id){
        begin();
        this.singleUser = service.findUser(Long.parseLong(id));
        return "/user/profile";
    }
    public String findCharity(String id){
        begin();
        this.singleCharity = service.findCharity(Long.parseLong(id));
        return "/charity/profile";
    }
    public String findActivity(String id){
        begin();
        this.singleActivity = service.findActivity(Long.parseLong(id));
        return "/user/activity";
    }
    public String findCause(String id){
        begin();
        this.singleCause = service.findCause(Long.parseLong(id));
        return "/charity/cause";
    }

    public DataService getService() {
        return service;
    }

    public void setService(DataService service) {
        this.service = service;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public UserAccount getSingleUser() {
        return singleUser;
    }

    public void setSingleUser(UserAccount singleUser) {
        this.singleUser = singleUser;
    }

    public CharityAccount getSingleCharity() {
        return singleCharity;
    }

    public void setSingleCharity(CharityAccount singleCharity) {
        this.singleCharity = singleCharity;
    }

    public Activity getSingleActivity() {
        return singleActivity;
    }

    public void setSingleActivity(Activity singleActivity) {
        this.singleActivity = singleActivity;
    }

    public Cause getSingleCause() {
        return singleCause;
    }

    public void setSingleCause(Cause singleCause) {
        this.singleCause = singleCause;
    }
    
}
