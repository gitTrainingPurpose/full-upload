
package com.visa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.product;
@Service
public class ProductServiceImpl implements ProductService {

    ProductDAO dao;
    @Autowired
    public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	public int addNewProduct(product p) {
        int id = 0;
        if(p.getPrice() * p.getQoh() >= 10000) {
            product created = dao.save(p);
            id = created.getID();
        }else {
            throw new IllegalArgumentException("min value of stock should be at least 10k");
        }
        return id;
    }

    public product findById(int id) {
        
        return dao.findByID(id);
    }

    public List<product> findAll() {
        
        return dao.findAll();
    }

    public void deleteProduct(int id) {
        product p = dao.findByID(id);
        if(p.getPrice() * p.getQoh() > 1000) {
            throw new IllegalArgumentException("can't remove when value > 1000");
        }else {
            dao.remove(id);
        }
        
    }
    
    

}
