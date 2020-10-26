package com.sterlite.microservice.product.repos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sterlite.microservice.product.entities.Product;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @creation_date 12th-Sep-2020
 * @version 1.0
 * @copyright Sterlite Technologies Ltd.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByName(String name);
	List<Product> findByBrand(String brand);
	List<Product> findByPrice(BigDecimal price);
	
	List<Product> findByNameAndBrand(String name,String brand);
	List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
