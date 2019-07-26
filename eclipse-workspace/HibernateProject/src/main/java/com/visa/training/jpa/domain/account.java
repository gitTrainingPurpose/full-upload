package com.visa.training.jpa.domain;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="acct_type",discriminatorType=DiscriminatorType.STRING)
public abstract class account {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    float balance;
    
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="cust_id")
    customer cust;
    public customer getCust() {
		return cust;
	}

	public void setCust(customer cust) {
		this.cust = cust;
	}

	public account() {
        // TODO Auto-generated constructor stub
    }

    public account(float balance) {
        super();
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    
    
}