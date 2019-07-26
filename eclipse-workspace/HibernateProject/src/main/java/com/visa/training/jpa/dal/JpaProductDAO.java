package com.visa.training.jpa.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.visa.training.jpa.domain.product;

public class JpaProductDAO {
	
	public List<product> findAll(){
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		Query q = em.createQuery("select p from product  as p");
		List<product> all=q.getResultList();
		em.close();
		return all;
	}
	
	public List<product> findByPriceGreaterThan(float price){
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		Query q = em.createQuery("select p from product  as p where p.price > :priceParam");
		q.setParameter("priceParam", price);
		List<product> all=q.getResultList();
		em.close();
		return all;
	}
	
	public product save(product p) {
		EntityManagerFactory emf = JpaUtil.getEmf();
		EntityManager em = emf.createEntityManager();
		try{			
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(p);
			tx.commit();			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return p;
	}
	public product findByID(int id) {

		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			product p = em.find(product.class, id);
			return p;
		} finally {
			// TODO: handle finally clause
			em.close();
		}
	}
	public product update(product p) {
		EntityManagerFactory emf = JpaUtil.getEmf();
		EntityManager em = emf.createEntityManager();
		try{			
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.merge(p);
			tx.commit();			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return p;
	}
	public void remove(int id) {
		EntityManagerFactory emf = JpaUtil.getEmf();
		EntityManager em = emf.createEntityManager();
		try{			
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			product r = em.find(product.class, id);
			em.remove(r);
			tx.commit();			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
//		return true;;
	}
}
