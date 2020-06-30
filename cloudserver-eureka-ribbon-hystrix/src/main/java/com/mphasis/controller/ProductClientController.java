package com.mphasis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mphasis.domain.Product;
import com.mphasis.service.ProductClientService;

@RestController
@Scope("request")
public class ProductClientController {

	@Autowired
	@Qualifier("productClientService")
	private ProductClientService productClientService;
	
	@GetMapping("/get-products/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		
		Product product = productClientService.getProductById(id);
		return product;
	}

}





