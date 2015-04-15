package com.jz99.fundraisingsite.jpa;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


@Entity
@NamedQuery(name="getAccount", query="SELECT DISTINCT a.account FROM SystemUser a WHERE a.USERNAME = LOWER(:username)")
public class SystemUser implements Serializable {
    @Id
    @NotNull
    String USERNAME;
    @NotNull
    String USERPASSWORD;
    @NotNull    @OneToOne   @JoinColumn(name="accountId")
    Account account;


    public SystemUser() {
    }

    public SystemUser(String username, String userpassword, Account account) {
        this.USERNAME = username;
        this.USERPASSWORD = userpassword;
        this.account = account;
        
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getUSERPASSWORD() {
        return USERPASSWORD;
    }

    public void setUSERPASSWORD(String USERPASSWORD) {
        this.USERPASSWORD = USERPASSWORD;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.USERNAME);
        hash = 47 * hash + Objects.hashCode(this.USERPASSWORD);
        hash = 47 * hash + Objects.hashCode(this.account);
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
        final SystemUser other = (SystemUser) obj;
        if (!Objects.equals(this.USERNAME, other.USERNAME)) {
            return false;
        }
        if (!Objects.equals(this.USERPASSWORD, other.USERPASSWORD)) {
            return false;
        }
        if (!Objects.equals(this.account, other.account)) {
            return false;
        }
        return true;
    }

    
    

    
}
