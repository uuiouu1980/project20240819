package com.example.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.member;

@Mapper
public interface memberMapper {
	//create
	@Insert("insert into member(memberNo,name,username,password) "
			+ "values(#{memberNo},#{name},#{username},#{password})")
	void add(member m);
	
	//read
	//判斷帳號
	@Select("select * from member where username=#{username} and password=#{password}")
	member queryMember(String username,String password);
	
	//有沒有重複
	@Select("select * from member where username=#{username} ")
	member queryUsername(String username);
	
	
	//update
	
	
	//delete

}