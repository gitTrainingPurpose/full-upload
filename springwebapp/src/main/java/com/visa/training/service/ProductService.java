package com.visa.training.service;

import java.util.List;

import com.visa.training.domain.product;

public interface ProductService {
	public int addNewProduct(product p);
	public product findById(int d);
	public List<product> findAll();
	public void deleteProduct(int id);
	
}
