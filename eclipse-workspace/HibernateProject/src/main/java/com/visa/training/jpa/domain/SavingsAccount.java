

package com.visa.training.jpa.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SA")
public class SavingsAccount extends account {

   public SavingsAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

    public SavingsAccount(float balance) {
        super(balance);
        // TODO Auto-generated constructor stub
    }

    
}