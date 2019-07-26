package com.visa.training.bootproject.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.visa.training.bootproject.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer>{
	public Product findById(int id);
	public List<Product> findAll();
	
	public List<Product> findByPrice(float somePrice);
	public List<Product>
	findByPriceLessThan(float somePrice); 
	public List<Product> findByName(String
	name);
	  
	/*
	@Query("UPDATE u FROM Product u WHERE u.id = ?1") 
	public void updateProduct(Integer id,Product p);
	*/
	
	
}
