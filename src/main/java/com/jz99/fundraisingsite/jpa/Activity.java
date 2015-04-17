/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joe
 */
@Entity
@NamedQueries({
    @NamedQuery(name="listActivities", query="SELECT a FROM Activity a"),
    @NamedQuery(name="getActivityByName", query="SELECT a FROM Activity a WHERE a.name = LOWER(:name)"),
    @NamedQuery(name="getActivity", query="SELECT a FROM Activity a WHERE a.id = (:id)")
})


public class Activity implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String info;
    @ManyToOne
    private Cause cause;
    @ManyToOne
    private UserAccount fundraiser;
    @OneToMany(mappedBy="activity")
    private List<Donation> donations;
    
    
    public Activity(){
        
    }

    public Activity(String name, String info, Cause cause, UserAccount fundraiser) {
        this.name = name;
        this.info = info;
        this.cause = cause;
        this.fundraiser = fundraiser;
        this.donations = new ArrayList<>();
        
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Cause getCause() {
        return cause;
    }

    public void setCause(Cause cause) {
        this.cause = cause;
    }

    public UserAccount getFundraiser() {
        return fundraiser;
    }

    public void setFundraiser(UserAccount fundraiser) {
        this.fundraiser = fundraiser;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.info);
        hash = 89 * hash + Objects.hashCode(this.cause);
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
        final Activity other = (Activity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.info, other.info)) {
            return false;
        }
        if (!Objects.equals(this.cause, other.cause)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
