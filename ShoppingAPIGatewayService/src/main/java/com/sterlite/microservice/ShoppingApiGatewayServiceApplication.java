package com.sterlite.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @creation_date 14th-Sep-2020
 * @version 1.0
 * @copyright Sterlite Technologies Ltd.
 */
@EnableZuulProxy
@SpringBootApplication
public class ShoppingApiGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApiGatewayServiceApplication.class, args);
	}

}
