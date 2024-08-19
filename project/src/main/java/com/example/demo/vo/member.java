package com.example.demo.vo;

import lombok.Data;

@Data
public class member {
	private Integer id;
	private String memberNo;
	private String name;
	private String username;
	private String password;
	public member(String memberNo, String name, String username, String password) {
		super();
		this.memberNo = memberNo;
		this.name = name;
		this.username = username;
		this.password = password;
	}
	public member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}