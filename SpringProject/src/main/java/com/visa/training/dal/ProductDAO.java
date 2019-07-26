package com.visa.training.dal;

import java.util.List;

import com.visa.training.domain.product;

public interface ProductDAO {
	public product save(product save);
	public product findByID(int id);
	public List<product> findAll();
	public void update(product p);
	public void remove(int id);	
}
