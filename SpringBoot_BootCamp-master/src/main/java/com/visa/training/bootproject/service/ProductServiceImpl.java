package com.visa.training.bootproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.training.bootproject.dal.ProductRepository;
import com.visa.training.bootproject.domain.Product;


@Service
public class ProductServiceImpl implements ProductService {

	ProductRepository dao;

	@Autowired
	public void setDao(ProductRepository dao) {
		this.dao = dao;
	}

	@Override
	public int addNewProduct(Product p) {
		int id = 0;
		
		if(p.getPrice()*p.getQoh()>=10000)
		{
			Product created = dao.save(p);
			System.out.println(created);
		}
		else
		{
			throw new IllegalArgumentException("min value of stock must be 10k");
		}
		return id;
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void deleteProduct(int id,Product tobedeleted) {
		// TODO Auto-generated method stub
		Product p = dao.findById(id);
		if(p.getPrice()*p.getQoh()>1000)
		{
			throw new IllegalArgumentException("can't remove when value>1000");
		}
		else
		{
			dao.deleteById(id);
		}
		
	}

	@Override
	public void update(Product p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product updateProduct(Integer id,Product p) throws Exception {
		// TODO Auto-generated method stub
		Product ps = dao.findById(id).get();
		
		if(ps!=null)
		{
			ps.setName(p.getName());
			ps.setPrice(p.getPrice());
			ps.setQoh(p.getQoh());
			dao.save(ps);
			return ps;
		}
		else 
		{
			throw new IllegalArgumentException("cant find the id");
		}
	}

}
