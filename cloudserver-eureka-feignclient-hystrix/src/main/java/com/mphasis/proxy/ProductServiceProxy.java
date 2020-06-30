package com.mphasis.proxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mphasis.domain.Product;
import com.mphasis.fallback.ProductServiceFallback;

@FeignClient(name="product-service", fallback = ProductServiceFallback.class)
public interface ProductServiceProxy {

	@GetMapping(value = "/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Product getProductById(@PathVariable("id") int id);

	@GetMapping(value = "/products", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Product> getAllProducts();
	
	/*
	@PostMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code =  HttpStatus.CREATED)
	public Product addProduct(@RequestBody Product product);
	
	@PutMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code =  HttpStatus.OK)
	public Product updateProduct(@RequestBody Product product);
	
	@DeleteMapping(value = "/products/{id}")
	@ResponseStatus(code =  HttpStatus.NO_CONTENT)
	public void deleteProductById(@PathVariable("id") Integer id);
	*/
}
