package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection c = JdbcUtil.getConnection();
		DatabaseMetaData metaData = c.getMetaData();
		System.out.println("Product is "+metaData.getDatabaseProductName());
		System.out.println("Version is "+metaData.getDatabaseProductVersion());
		c.close();
		ProductDAO daoTest = new ProductDAO();
		daoTest.save(new Product(7,"yashasvi",24.4f,12));
//		System.out.println(daoTest.findByID(1).toString());
//		System.out.println(daoTest.findAll());
//		daoTest.remove(1);
		System.out.println(daoTest.findAll());
		
		
		
		
	}

}
