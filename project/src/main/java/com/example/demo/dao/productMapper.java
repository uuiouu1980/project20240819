package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.product;
import com.example.demo.vo.queryMember;

@Mapper
public interface productMapper {
	//create
	@Insert("insert into product(productNo,productName,price) "
			+ "values(#{productNo},#{productName},#{price})")
	void add(product p);
	
	//Read
	@Select("select * from product")
	List<product> queryAll();
	
	@Select("select * from product where id=#{id}")
	product queryId(int id);
	

		
	//update
		
	@Update("update product set productNo=#{productNo},productName=#{productName},price=#{price} where id=#{id}")
	void update(product p);
		
	//delete
	@Delete("delete from product where id=#{id}")
	void delete(int id);
	
	@Delete("delete from product where id>=#{start} and id<=#{end}")
	void deleteStartEnd(int start,int end);


}