package com.mphasis.fallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mphasis.domain.Product;
import com.mphasis.proxy.ProductServiceProxy;

@Service("ProductServiceFallback")
public class ProductServiceFallback implements ProductServiceProxy {

	@Override
	public Product getProductById(int id) {

		return new Product(id, "DELL", 42423.0);
	}

	@Override
	public List<Product> getAllProducts() {
		
		return Arrays.asList(new Product());
	}

}
