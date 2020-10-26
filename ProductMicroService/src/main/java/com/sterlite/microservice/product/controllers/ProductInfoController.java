package com.sterlite.microservice.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sterlite.microservice.product.beans.ProductServiceInfo;
import com.sterlite.microservice.product.entities.Product;
import com.sterlite.microservice.product.exceptions.ProductNotFoundException;
import com.sterlite.microservice.product.repos.ProductRepository;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @creation_date 12th-Sep-2020
 * @version 1.0
 * @copyright Sterlite Technologies Ltd.
 */
@RequestMapping("/products")
@RestController
public class ProductInfoController {
	
	@Autowired
	private Environment env;

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/id/{id}")
	public ProductServiceInfo getProduct(@PathVariable long id) {
		Product product = productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Sorry! Product with id " + id + " not found"));
		
		int serverPort = Integer.parseInt(env.getProperty("server.port"));
		
		return new ProductServiceInfo(product, serverPort);
	}
}
