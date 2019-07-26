package com.visa.training.bootproject.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.visa.training.bootproject.domain.Product;
import com.visa.training.bootproject.service.ProductService;
@Component
public class ProductConsoleUI {
	
	ProductService service ;
	//autowiring
	
	@Autowired
	public void setService(ProductService Service)
	{
		this.service = Service;
	}
	
	public void createProdductWithUI() {
		Scanner kb = new Scanner(System.in);
		System.out.println("enter a name");
		String name = kb.nextLine();
		System.out.println("Enter a price:");
		float price = Float.parseFloat(kb.nextLine());
		System.out.println("Enter Qoh");
		int qoh = Integer.parseInt(kb.nextLine());
		
		Product p = new Product(name,price,qoh);
		try {
			int id = service.addNewProduct(p);
			System.out.println("Product created");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			System.out.println("Value too low for creation");
			e.printStackTrace();
		}
		
	}

	
}
