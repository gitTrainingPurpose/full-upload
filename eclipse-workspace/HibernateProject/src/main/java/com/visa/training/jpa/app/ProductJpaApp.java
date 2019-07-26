package com.visa.training.jpa.app;

import java.util.List;

import com.visa.training.jpa.dal.JpaProductDAO;
import com.visa.training.jpa.domain.product;

public class ProductJpaApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * JpaProductDAO dao = new JpaProductDAO(); product test = new
		 * product("hibernate", 9999, 1000); product saved = dao.save(test);
		 * System.out.println(saved); product p = dao.findByID(9);
		 * System.out.println(p); p.setPrice( 11111); p = dao.update(p);
		 * System.out.println(p); dao.remove(9); System.exit(0);
		 */
		JpaProductDAO dao = new JpaProductDAO();
		List<product> all = dao.findByPriceGreaterThan(100.0f);		
		all.forEach(System.out::println);
		
		
	}

}
