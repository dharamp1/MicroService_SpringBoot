package com.sterlite.microservice.product.beans;

import com.sterlite.microservice.product.entities.Product;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @creation_date 12th-Sep-2020
 * @version 1.0
 * @copyright Sterlite Technologies Ltd.
 */
public class ProductServiceInfo {
	
	private Product product;
	private int serverPort;
	
	public ProductServiceInfo() {
		// TODO Auto-generated constructor stub
	}

	public ProductServiceInfo(Product product, int serverPort) {
		super();
		this.product = product;
		this.serverPort = serverPort;
	}

	public Product getProduct() {
		return product;
	}

	public int getServerPort() {
		return serverPort;
	}

	@Override
	public String toString() {
		return "ProductServiceInfo [product=" + product + ", serverPort=" + serverPort + "]";
	}
}
