package com.sterlite.microservice.shopping.cart.services;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sterlite.microservice.shopping.cart.beans.CartItem;
import com.sterlite.microservice.shopping.cart.beans.CartServiceInfo;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @creation_date 12th-Sep-2020
 * @version 1.0
 * @copyright Sterlite Technologies Ltd.
 */
//@FeignClient(name = "product-service",url = "localhost:8082")
@FeignClient(name = "product-service")
@RibbonClient(name = "product-service")
public interface CartItemServiceProxy {
	
	@GetMapping("/products/id/{id}")
	CartServiceInfo retrieveByProductId(@PathVariable long id);
}
