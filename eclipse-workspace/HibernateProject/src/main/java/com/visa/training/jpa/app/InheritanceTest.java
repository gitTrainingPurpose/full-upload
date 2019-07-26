package com.visa.training.jpa.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.visa.training.jpa.dal.JpaUtil;
import com.visa.training.jpa.domain.account;
import com.visa.training.jpa.domain.CurrentAccount;
import com.visa.training.jpa.domain.SavingsAccount;

public class InheritanceTest {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		SavingsAccount sa = new SavingsAccount(10000);
		CurrentAccount ca = new CurrentAccount(10000,10000);
		em.persist(sa);
		em.persist(ca);
		tx.commit();
		account unknownType = em.find(account.class, sa.getId());
		System.out.println("This account is of type: "+unknownType.getClass().getName());
		em.close();
		System.exit(0);
		
	}
}
