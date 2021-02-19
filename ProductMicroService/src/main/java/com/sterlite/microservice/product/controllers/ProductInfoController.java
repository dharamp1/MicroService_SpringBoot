package com.sterlite.microservice.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@CrossOrigin
	@GetMapping
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable long id) {
		return productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Sorry! Product with id " + id + " not found"));
	}
	
	@CrossOrigin
	@PostMapping
	public @ResponseBody Product addProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@CrossOrigin
	@PutMapping
	public @ResponseBody Product updateProductById(@RequestBody Product product) {
		System.out.println("update called " + product);
		return productRepository.save(product);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public @ResponseBody void removeProductById(@PathVariable long id) {
		System.out.println("delete called");
		Product product = productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Sorry! Product with id " + id + " not found"));
		productRepository.deleteById(product.getId());
	}
	
	
	
}
