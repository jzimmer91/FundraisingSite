/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.jpa;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Joe
 */
@Entity
public class AdminAccount extends Account implements Serializable {
    
    @NotNull
    private String USERNAME;
    
    public AdminAccount(){
        
    }
    
    public AdminAccount(String USERNAME){
        this.USERNAME = USERNAME;
        setUsername(USERNAME);
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.USERNAME);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AdminAccount other = (AdminAccount) obj;
        if (!Objects.equals(this.USERNAME, other.USERNAME)) {
            return false;
        }
        return true;
    }
    
    
}
