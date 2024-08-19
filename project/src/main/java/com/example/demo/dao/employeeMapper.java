package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.employee;
import com.example.demo.vo.porder;
import com.example.demo.vo.product;
import com.example.demo.vo.queryMember;
@Mapper
public interface employeeMapper {
	//create
	@Insert("insert into employee(employeeNo,name,username,password,type) "
			+ "values(#{employeeNo},#{name},#{username},#{password},#{type})")
	void add(employee e);
	
	
	//read
	@Select("select * from employee where username=#{username} and password=#{password}")
	employee queryUser(String username,String password);
	
	@Select("select * from employee where username=#{username} ")
	employee queryUsername(String username);
	
	@Select("select * from employee")
	List<employee> queryAll();
	
	@Select("select * from employee where name=#{name}")
	List<employee> queryName(String name);
	
	@Select("select * from employee where id=#{id}")
	employee queryId(int id);
	
	
	//update
	@Update("update employee set name=#{name},password=#{password} where id=#{id}")
	void update(employee e);
	
	
	//delete
	@Delete("delete from employee where id=#{id}")
	void delete(int id);
	
	

}
