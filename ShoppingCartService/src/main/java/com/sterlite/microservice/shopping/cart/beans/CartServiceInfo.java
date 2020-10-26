package com.sterlite.microservice.shopping.cart.beans;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @creation_date 12th-Sep-2020
 * @version 1.0
 * @copyright Sterlite Technologies Ltd.
 */
public class CartServiceInfo {
	
	CartItem product;
	int serverPort;
	
	public CartServiceInfo() {
		// TODO Auto-generated constructor stub
	}

	public CartServiceInfo(CartItem product, int serverPort) {
		super();
		this.product = product;
		this.serverPort = serverPort;
	}

	public CartItem getProduct() {
		return product;
	}

	public int getServerPort() {
		return serverPort;
	}

	@Override
	public String toString() {
		return "CartServiceInfo [product=" + product + ", serverPort=" + serverPort + "]";
	}

	
}
