/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.jpa;

import java.io.Serializable;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull    @OneToOne   @JoinColumn(name="USERNAME")
    private SystemUser USERNAME;
    @NotNull
    private String GROUPNAME;
    
    public Long getId() {
        return id;
    }

    public SystemUserGroup() {
    }
    public SystemUserGroup(SystemUser username, String groupname){
        this.USERNAME = username;
        this.GROUPNAME= groupname;
    }

    public SystemUser getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(SystemUser USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getGROUPNAME() {
        return GROUPNAME;
    }

    public void setGROUPNAME(String GROUPNAME) {
        this.GROUPNAME = GROUPNAME;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SystemUserGroup)) {
            return false;
        }
        SystemUserGroup other = (SystemUserGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gp225.securityexercise2.entity.SystemUserGroup[ id=" + id + " ]";
    }
    
}