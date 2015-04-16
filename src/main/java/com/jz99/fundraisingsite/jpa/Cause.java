/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Joe
 */
@Entity
@NamedQueries({
@NamedQuery(name="listCauses", query="SELECT c FROM Cause c ORDER BY c.name"),
@NamedQuery(name="selectCause", query="SELECT DISTINCT c FROM Cause c WHERE c.name = LOWER(:name)")
})

public class Cause implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String info;
    @ManyToOne
    private CharityAccount charity;
    @OneToMany(mappedBy="cause")
    private List<Activity> activities;
    @OneToMany(mappedBy="cause")
    private List<Donation> donations;
    
    public Cause(){
        
    }

    public Cause(String name, String info, CharityAccount charity) {
        this.name = name;
        this.info = info;
        this.charity = charity;
        this.activities = new ArrayList<>();
        this.donations = new ArrayList<>();
        //addSelf();
    }
    
//    private void addSelf(){
//        charity.addCause(this);
//    }
//    public void addActivity(Activity activity){
//        if(!activities.contains(activity)){
//            activities.add(activity);
//        }
//    }
//    public void addDonation(Donation donation){
//        if(!donations.contains(donation)){
//            donations.add(donation);
//        }
//    }

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

    public CharityAccount getCharity() {
        return charity;
    }

    public void setCharity(CharityAccount charity) {
        this.charity = charity;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }
    

    @Override
    public String toString() {
        return name;
    }
    
    
}
