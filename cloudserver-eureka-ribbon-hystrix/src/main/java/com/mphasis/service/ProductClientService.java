package com.mphasis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.mphasis.domain.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service("productClientService")
@Scope("singleton")
public class ProductClientService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "defaultProductDetails")
	public Product getProductById(int id) {

		Product product = restTemplate.getForObject("http://product-service/products/" + id, Product.class);
		return product;
	}
	
	public Product defaultProductDetails(int id) {
		
		return new Product(id, "DELL", 42233.0);
	}
}






