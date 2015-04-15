/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.jpa;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Joe
 */
@Entity
public class SystemUserGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    private String USERNAME;
    @NotNull
    private String GROUPNAME;
    
    
    

    public SystemUserGroup() {
    }
    public SystemUserGroup(String username, String groupname){
        this.USERNAME = username;
        this.GROUPNAME= groupname;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getGROUPNAME() {
        return GROUPNAME;
    }

    public void setGROUPNAME(String GROUPNAME) {
        this.GROUPNAME = GROUPNAME;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.USERNAME);
        hash = 89 * hash + Objects.hashCode(this.GROUPNAME);
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
        final SystemUserGroup other = (SystemUserGroup) obj;
        if (!Objects.equals(this.USERNAME, other.USERNAME)) {
            return false;
        }
        if (!Objects.equals(this.GROUPNAME, other.GROUPNAME)) {
            return false;
        }
        return true;
    }

    

    
}
