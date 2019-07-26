package com.visa.training.jpa.app;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.visa.training.jpa.dal.JpaUtil;
import com.visa.training.jpa.domain.Address;
import com.visa.training.jpa.domain.SavingsAccount;
import com.visa.training.jpa.domain.account;
import com.visa.training.jpa.domain.customer;

public class AssocianTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		createAccountAndCustomerTogether();
//		readAccountAlongWithCustomer();
//		testLazy();
		testManyToMany();

	}
	public static void testManyToMany() {
			EntityManager em = JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			customer c = new customer("ffn","mmn","lln",new Date(System.currentTimeMillis()));
			Address a= new Address("sl1", "sl2", "city", "state", "500068", "country");
			c.getAddresses().add(a);
			em.persist(c);
			tx.commit();em.close();
	
	
	
	}
	public static void testLazy() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		customer c1 = em.find(customer.class, 39);
		em.close();
		account a = c1.getAccounts().get(0);
		System.out.println(c1);
		
	}
	private static void  readAccountAlongWithCustomer() {
		EntityManager em =JpaUtil.getEmf().createEntityManager();
		SavingsAccount sa = em.find(SavingsAccount.class, 32);
		System.out.println(sa);
		
		em.close();
	}
	private static void createAccountAndCustomerTogether() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		customer c =new customer("fn","mn","ln",new Date(System.currentTimeMillis()));
		SavingsAccount sa = new SavingsAccount(1234);
		sa.setCust(c);
		/*
		 * em.persist(c); em.persist(sa);
		 */
		em.persist(sa);
		
		tx.commit();
		em.close();
		System.exit(0);
	}
	private static void createAccountAndCustomerSeparately() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		customer c =new customer("fn","mn","ln",new Date(System.currentTimeMillis()));
		SavingsAccount sa = new SavingsAccount(1234);
		sa.setCust(c);
		em.persist(c);
		em.persist(sa);
		
		
		tx.commit();
		em.close();
		System.exit(0);
	}
}
