package com.example.demo.vo;

import lombok.Data;

@Data
public class porder {
	private Integer id;
	private String porderNo;
	private String productNo;
	private String memberNo;
	private Integer amount;
	public porder(String porderNo, String productNo, String memberNo, Integer amount) {
		super();
		this.porderNo = porderNo;
		this.productNo = productNo;
		this.memberNo = memberNo;
		this.amount = amount;
	}
	public porder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}