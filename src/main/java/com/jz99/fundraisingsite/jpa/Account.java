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

/**
 *
 * @author Joe
 */
@Entity
public abstract class Account implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    public Long getAccountId() {
        return accountId;
    }
    
}
