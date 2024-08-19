package com.example.demo.vo;

import lombok.Data;

@Data
public class product {
	private Integer id;
	private String productNo;
	private String productName;
	private Integer price;
	public product(String productNo, String productName, Integer price) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.price = price;
	}
	public product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}