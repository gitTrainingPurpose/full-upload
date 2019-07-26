package com.visa.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.visa.training.domain.product;

@Repository
@Transactional
public class ProductDaoJpaImpl implements ProductDAO{
	@PersistenceContext
	EntityManager em;
	
	public product save(product save) {
		// TODO Auto-generated method stub
		em.persist(save);
		return save;
	}

	public product findByID(int id) {
		// TODO Auto-generated method stub
		
		return em.find(product.class, id);
	}

	public List<product> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select p from product as p").getResultList();
//		return null;
	}

	public void update(product p) {
		// TODO Auto-generated method stub
		em.merge(p);
	}

	public void remove(int id) {
		// TODO Auto-generated method stub
		product p = em.find(product.class, id);
		em.remove(p);
	}

}
