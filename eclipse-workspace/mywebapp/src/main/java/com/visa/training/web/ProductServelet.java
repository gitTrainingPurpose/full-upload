package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visa.training.jdbc.Product;
import com.visa.training.jdbc.ProductDAO;

/**
 * Servlet implementation class ProductServelet
 */
@WebServlet("/product")
public class ProductServelet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id1");
		String name = request.getParameter("n1");
		String price = request.getParameter("p1");
		String qoh = request.getParameter("qoh1");
		int id1 = Integer.parseInt(id);
		Float price1 = Float.parseFloat(price);
		int qoh1 = Integer.parseInt(qoh);
		ProductDAO daoTest = new ProductDAO();
		int genID = daoTest.save(new Product(id1,name,price1,qoh1));
		PrintWriter out = response.getWriter();
		out.println("ID of the product inserted = "+genID);
		out.println(daoTest.findById(genID));
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		doGet(request, response);
	}

}
