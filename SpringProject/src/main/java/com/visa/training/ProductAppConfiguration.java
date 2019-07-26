package com.visa.training;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.visa.training")
public class ProductAppConfiguration {
	
	/*
	 * @Bean public ProductDAO dao() { return new ProductDAOInMemoryImpl(); }
	 * 
	 * @Bean public ProductService service() { ProductServiceImpl service = new
	 * ProductServiceImpl(); service.setDao(dao()); return service; }
	 * 
	 * @Bean public ProductConsoleUI ui(){ ProductConsoleUI ui = new
	 * ProductConsoleUI(); ui.setService(service()); return ui; }
	 */
	
}
