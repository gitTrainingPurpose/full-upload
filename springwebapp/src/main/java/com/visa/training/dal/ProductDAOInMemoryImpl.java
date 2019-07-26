package com.visa.training.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.visa.training.domain.product;

//@Repository
public class ProductDAOInMemoryImpl implements ProductDAO{
	int idSequence;
	Map<Integer,product> data = new HashMap<Integer, product>();
	public product save(product p) {
		// TODO Auto-generated method stub
		int id = ++idSequence;
		p.setID(id);
		data.put(id,p);
		return p;
	}
	public product findByID(int id) {
		// TODO Auto-generated method stub
		return data.get(id);
	}
	public List<product> findAll() {
		return new ArrayList<product>(data.values());
	}
	public void update(product p) {
		// TODO Auto-generated method stub
		data.put(p.getID(), p);
		
	}
	public void remove(int id) {
		// TODO Auto-generated method stub
		data.remove(id);
	}
	
}
