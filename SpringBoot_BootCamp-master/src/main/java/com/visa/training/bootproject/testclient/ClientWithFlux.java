
package com.visa.training.bootproject.testclient;

import java.net.URI;
import java.util.List;
import java.util.Scanner;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.visa.training.bootproject.domain.Product;

import reactor.core.publisher.Flux;

public class ClientWithFlux {

    public static void main(String[] args) {
        //createProductWithUI();
        long start = System.currentTimeMillis();
    	System.out.println("All Products : ");
        
        listProducts();
        long end  = System.currentTimeMillis();
        System.out.println("listing took"+(end-start));
        doSomeOtherWork();
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private static void doSomeOtherWork() {
		// TODO Auto-generated method stub
    	System.out.println("Doing some other work..........");
		
	}

	private static void listProducts() {
        WebClient client = WebClient.create("http://localhost::8080");
        
        //List<Product> products = response.getBody();
        
//        ResponseEntity<List<Product>> response = template.exchange
//        		("http://localhost:8080/api/products", 
//                HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>(){});
//        
//        List<Product> list = response.getBody();
        
        Flux<Product> all = client.get().uri("/api/products").retrieve().bodyToFlux(Product.class);
        //list.forEach(System.out::println);
        
        all.subscribe(System.out::println);
    }

    public static void createProductWithUI() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter a name: ");
        String name = kb.nextLine();
        System.out.println("Enter a price : ");
        float price = Float.parseFloat(kb.nextLine());
        System.out.println("Enter a qoh : ");
        int qoh = Integer.parseInt(kb.nextLine());
        
        Product p = new Product(name, price, qoh);
        try {
            RestTemplate template = new RestTemplate();
            URI uri = template.postForLocation("http://localhost:8080/api/products", p);
            System.out.println("Created product with uri : "+uri.toString());
        } catch (Exception e) {
            //System.out.println("Value too low for creation");
            e.printStackTrace();
        }
        

    }

}


