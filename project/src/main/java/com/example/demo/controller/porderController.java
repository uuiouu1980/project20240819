package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.porderMapper;
import com.example.demo.vo.member;
import com.example.demo.vo.porder;
import com.example.demo.vo.queryMember;
import com.example.demo.vo.updateporder;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("porder")
public class porderController {
	@Autowired
	porderMapper pordermapper;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("porder")
	public String porder()
	{
		return "/porder/porder";
		 
	}
	
	/**********進入購物流程**************/
	
	@GetMapping("addPorder")
	public String addPorder()
	{
		return "/porder/addPorder";
		 
	}
	
	@PostMapping("confirm")
	public String confirm(String porderNo,String productNo,int amount )
	{
		member m=(member)session.getAttribute("M");
		porder p=new porder(porderNo,productNo,m.getMemberNo(),amount);
		session.setAttribute("P", p);
		
		return "/porder/confirm";
		 
	}
	
	@GetMapping("finish")
	public String finish()
	{
		porder p=(porder)session.getAttribute("P");
		pordermapper.add(p);
		
		return "/porder/finish";
		 
	}
	
	/**********查詢**************/
	
	@GetMapping("query")
	public String query()
	{
		return "/porder/query";
		 
	}
	
	/**********查詢全部購買金額**************/
	
	@GetMapping("queryMember")
	public String queryMember()
	{
		member m=(member)session.getAttribute("M");
		
		List<queryMember> l=pordermapper.queryMember(m.getName());
		session.setAttribute("L", l);
		
		return "/porder/queryMember";//切到queryMember.jsp
		
	}
	
	/**********查詢訂購金額範圍**************/
	@RequestMapping("queryAmount")
	public String queryAmount()
	{
		/*
		 * 1.開始/輸入空白,null-->queryMember(String name)-->List
		 * 2.輸入表單--->queryMemberSum(String name,int start,int end);--->List
		 */
		
		String Start=request.getParameter("start");
		String End=request.getParameter("end");
		member m=(member)session.getAttribute("M");
		List<queryMember> l=null;
		
		if(Start!=null && Start!="" && End!=null && End!="")
		{
			int S=Integer.parseInt(Start);
			int E=Integer.parseInt(End);
			l=pordermapper.queryMemberSum(m.getName(), S, E);
		}
		else
		{
			l=pordermapper.queryMember(m.getName());
		}
		
		session.setAttribute("L", l);
		
		return "/porder/queryAmount";
		 
	}
	
	/**********修改**************/
	
	@RequestMapping("updateQueryByname")
	public String updateQueryByname()
	{
		
		String PorderNo=request.getParameter("porderNo");
		String ProductNo=request.getParameter("productNo");
		String Amount=request.getParameter("amount");
		
//		System.out.println(PorderNo+"\t"+ProductNo+"\t"+Amount);
		
		if(PorderNo!=null && PorderNo!="" && ProductNo!=null && ProductNo!="" && Amount!=null && Amount!="")
		{
			int a=Integer.parseInt(Amount);
			porder p=pordermapper.queryPorder(PorderNo);
			p.setProductNo(ProductNo);
			p.setAmount(a);
//			System.out.println(p+"\t"+p.getPorderNo());
			pordermapper.update(p);
			
		}
		member m=(member)session.getAttribute("M");
		
		List<updateporder> l=pordermapper.updateQueryByname(m.getName());
		session.setAttribute("L", l);
		
		return "porder/update";
		
	}
	
	/**********刪除**************/
	
	@RequestMapping("delete")
    public String delete() 
	{
		String PorderNo=request.getParameter("porderNo");
		
		if(PorderNo!=null && PorderNo!="")
		{
			
			pordermapper.delete(PorderNo);
			
		}
		member m=(member)session.getAttribute("M");
		
		List<updateporder> l=pordermapper.updateQueryByname(m.getName());
		session.setAttribute("L", l);

        return "porder/delete";
    } 
}

