package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.porderMapper;
import com.example.demo.dao.productMapper;
import com.example.demo.vo.employee;
import com.example.demo.vo.member;
import com.example.demo.vo.porder;
import com.example.demo.vo.product;
import com.example.demo.vo.queryMember;
import com.example.demo.vo.updateporder;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("product")
public class productController {
	@Autowired
	productMapper productmapper;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("product")
	public String product()
	{
		return "/product/product";
		 
	}
	/**********進入產品新增流程**************/
	@GetMapping("addProduct")
	public String addPorder()
	{
		return "/product/addProduct";
		 
	}
	
	@PostMapping("confirm")
	public String confirm(String productNo,String productName,int price )
	{
		employee e=(employee) session.getAttribute("E");
		product p=new product(productNo,productName,price);
		session.setAttribute("PR", p);
		
		return "/product/confirm";
		 
	}
	
	@GetMapping("finish")
	public String finish()
	{
		product p=(product)session.getAttribute("PR");
		productmapper.add(p);
		
		return "/product/finish";
		 
	}
	
	/**********查詢**************/
	
	@GetMapping("query")
	public String query()
	{
		employee e=(employee) session.getAttribute("E");
		List<product> l=productmapper.queryAll();
		session.setAttribute("L", l);
		return "/product/query";
		 
	}
	
	
	/**********修改**************/
	
	@RequestMapping("update")
	public String update()
	{
		String Id=request.getParameter("id");
		String ProductNo=request.getParameter("productNo");
		String ProductName=request.getParameter("productName");
		String Price=request.getParameter("price");
		
		if(Id!=null && Id!="" && ProductNo!=null && ProductNo!="" && ProductName!=null && ProductName!=""&& Price!=null && Price!="")
		{
			int a=Integer.parseInt(Id);
			int b=Integer.parseInt(Price);
			product p=productmapper.queryId(a);
			p.setProductNo(ProductNo);
			p.setProductName(ProductName);
			p.setPrice(b);
			productmapper.update(p);
			
			
		}
		
		employee e=(employee) session.getAttribute("E");
		List<product> l=productmapper.queryAll();
		session.setAttribute("L", l);
		
		return "/product/update";
		

		 
	}
	
	/**********刪除**************/
	@RequestMapping("delete")
	public String delete() {
	    String Id = request.getParameter("id");
	    String Start = request.getParameter("start");
	    String End = request.getParameter("end");

	    if (Id!=null && Id!="") {
	        int a = Integer.parseInt(Id);
	        productmapper.delete(a);

	    } else if (Start!=null && Start!="" && End!=null && End!="") {
	        int S = Integer.parseInt(Start);
	        int E = Integer.parseInt(End);
	        productmapper.deleteStartEnd(S, E); 
	    }

	    employee e = (employee) session.getAttribute("E");
	    List<product> l = productmapper.queryAll();
	    session.setAttribute("L", l);
	    return "/product/delete";
	}

//	@RequestMapping("delete")
//	public String delete()
//	{
//		String Id=request.getParameter("id");
//		
//		
//		if(Id!=null && Id!="")
//		{
//			int a=Integer.parseInt(Id);
//			productmapper.delete(a);
//		}
//		
//		employee e=(employee) session.getAttribute("E");
//		List<product> l=productmapper.queryAll();
//		session.setAttribute("L", l);
//		return "/product/delete";
//		 
//	}

}
