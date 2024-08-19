	package com.example.demo.dao;
	
	import java.util.List;
	
	import org.apache.ibatis.annotations.Delete;
	import org.apache.ibatis.annotations.Insert;
	import org.apache.ibatis.annotations.Mapper;
	import org.apache.ibatis.annotations.Select;
	import org.apache.ibatis.annotations.Update;
	
	
	import com.example.demo.vo.porder;
	import com.example.demo.vo.queryMember;
	import com.example.demo.vo.updateporder;
	
	
	
	@Mapper
	public interface porderMapper {
		//create
		@Insert("insert into porder(porderNo,productNo,memberNo,amount) "
				+ "values(#{porderNo},#{productNo},#{memberNo},#{amount})")
		void add(porder p);
		
		//read
		
		@Select("select * from queryMember where name=#{name}")
		List<queryMember> queryMember(String name);
		
		@Select("select * from queryMember where name=#{name} and sum>=#{start} and sum<=#{end}")
		List<queryMember> queryMemberSum(String name,int start,int end);
		
		@Select("select * from updateporder where name=#{name}")
		List<updateporder> updateQueryByname(String name);
		
		@Select("select * from porder where porderNo=#{porderNo}")
		porder queryPorder(String porderNo);
		
		//update
		@Update("update porder set productNo=#{productNo},amount=#{amount} where porderNo=#{porderNo}")
		void update(porder p);
		
		//delete
		@Delete("delete from porder where porderNo=#{porderNo}")
		void delete(String porderNo);
	
	}