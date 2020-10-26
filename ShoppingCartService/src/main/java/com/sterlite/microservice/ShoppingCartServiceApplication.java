package com.sterlite.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
//import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @creation_date 12th-Sep-2020
 * @version 1.0
 * @copyright Sterlite Technologies Ltd.
 */
@EnableCircuitBreaker
@EnableFeignClients("com.sterlite.microservice.shopping.cart.services")
@SpringBootApplication
public class ShoppingCartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartServiceApplication.class, args);
	}
}
