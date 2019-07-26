package com.visa.training.bootproject.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.visa.training.bootproject.domain.Product;
import com.visa.training.bootproject.service.ProductService;

@RestController
public class ProductRestController {

	@Autowired
	ProductService service;
	
	@RequestMapping(value = "/api/products",method = RequestMethod.GET)
	public List<Product> getAll()
	{
		try {
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return service.findAll();
	}
	
	//path
	@RequestMapping(value = "/api/products/{id}",method = RequestMethod.GET)
	public ResponseEntity<Product> getById(@PathVariable("id")int id)
	{
		//return service.findById(id);
		Product p = service.findById(id);
		if(p!=null)
		{
			return new ResponseEntity<Product>(p,HttpStatus.OK);
		}
		else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/api/products",method= RequestMethod.POST)
	public ResponseEntity<Product> createProduct(@RequestBody Product tobeCreated)
	{
		try {
			int id = service.addNewProduct(tobeCreated);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/api/products/"+id));
			return new ResponseEntity(headers,HttpStatus.CREATED);
		}
		catch(IllegalArgumentException e)
		{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	//@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	@RequestMapping(value = "/api/products/{id}",method= RequestMethod.PUT)
	public ResponseEntity<Product> updationProduct(@RequestBody Product tobeUpdated,@PathVariable
			("id") int id)
	{
		try {
			Product p = service.updateProduct(id, tobeUpdated);
			HttpHeaders headers = new HttpHeaders();
			if(p!=null)
			{
				return new ResponseEntity<Product>(p,HttpStatus.OK);
			}
		}
		catch(Exception e)
		{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	@RequestMapping(value = "/api/products/{id}",method= RequestMethod.DELETE)
	public ResponseEntity<Product> deletionProduct(@RequestBody Product tobedeleted,@PathVariable
			("id") int id)
	{
		try {
			service.deleteProduct(id, tobedeleted);
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Product>(tobedeleted,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	
	}
}
