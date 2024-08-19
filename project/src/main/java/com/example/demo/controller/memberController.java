package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.memberMapper;
import com.example.demo.vo.member;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("member")
public class memberController {
	@Autowired
	memberMapper membermapper;
	@Autowired
	HttpServletResponse response;
	@Autowired
	HttpSession session;
	
	/**********會員登入**************/          
	@RequestMapping("login")
	public String login(String username,String password)//接收帳號密碼
	{
		/*
		 * 1.判斷null-->querymember
		 * 2.String--->success,error
		 */
		
		member m=membermapper.queryMember(username, password);
		
		if(m!=null)
		{
			session.setAttribute("M", m);
			return "/loginSuccess";
			
		}
		else
		{
			return "/loginError";
		}
		
	}
	
	/**********會員登出**************/ 
	 @GetMapping("logout")
	 public String logout()
		{
			session.removeAttribute("M");
			session.removeAttribute("P");
			
			return "/logout";
		}
	 
	 /**********新增會員**************/ 
	@PostMapping("addMember")
	public String addMember(String memberNo,String name,String username,String password)
	{
		member b=membermapper.queryUsername(username);
		
		if(b!=null)
		{
			return "/member/addMemberError";
		}
		else
		{
			member m=new member(memberNo,name,username,password);
			membermapper.add(m);
			
			return "/member/addMemberSuccess";
		}
		
	}

}


