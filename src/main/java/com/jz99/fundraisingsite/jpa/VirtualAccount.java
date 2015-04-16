/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;

/**
 *
 * @author Joe
 */
@Embeddable
public class VirtualAccount implements Serializable{
    
    @OneToMany
    private List<Donation> donations;
    
    
    public VirtualAccount(){
        this.donations = new ArrayList<>();
    }
        
    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }   

    
}
