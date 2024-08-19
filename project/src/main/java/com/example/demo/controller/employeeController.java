package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.employeeMapper;
import com.example.demo.vo.employee;
import com.example.demo.vo.member;
import com.example.demo.vo.product;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("employee")
public class employeeController {
	
	@Autowired
	private employeeMapper employeemapper;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	@Autowired
	HttpSession session;
	
	/**********員工登入系統**************/    
	@RequestMapping("Employee")
	public String login()
	{
		return "/employee/Employee";
	}

	/**********員工登入**************/   
	@RequestMapping("login")
	public String login(String username,String password)
	{
		employee e=employeemapper.queryUser(username, password);
		if(e!=null)
		{
			
			if(e.getType()==1)//1-->管理員  0-->一般員工
			{
				session.setAttribute("E", e);
				return "/employee/manager/managerLoginSuccess";
			}
			else
			{
				session.setAttribute("E", e);
				return "/employee/employee/employeeLoginSuccess";
			}
		}
		else
		{
			return "/employee/loginError";
		}
	}
	
	/**********員工登出**************/   
	@GetMapping("logout")
	 public String logout()
		{
			session.removeAttribute("E");
			session.removeAttribute("PR");
			session.removeAttribute("LP");
			session.removeAttribute("ELP");
			
			return "/employee/logout";
		}
	
	/**********管理員系統**************/
	
	@GetMapping("manager")
	public String manager()
	{
		return "/employee/manager/manager";
	}
	
	/**********管理員,員工資料**************/
	
	@GetMapping("managerStaff")
	public String managerStaff()
	{
		return "/employee/manager/managerStaff";
	}
	
	@RequestMapping("managerAddEmployee")
	public String managerAddEmployee()
	{
		return "/employee/manager/managerAddEmployee";
	}
	
	@RequestMapping("addEmployee")
	public String addEmployee(String employeeNo, String name, String username, String password, Integer type)
	{
		employee b=employeemapper.queryUsername(username);
		
		if(b!=null)
		{
			return "/employee/manager/addEmployeeError";
		}
		else
		{
			employee e=new employee(employeeNo,name,username,password,type);
			employeemapper.add(e);
			
			return "/employee/manager/addEmployeeSuccess";
		}
		
	}
	
	/**********查詢**************/
	@GetMapping("managerQuery")
	public String managerQuery()
	{
		return "/employee/manager/managerQuery";
	}
	
	@GetMapping("queryAll")
	public String queryAll()
	{
		employee e=(employee) session.getAttribute("E");
		List<employee> l=employeemapper.queryAll();
		session.setAttribute("L", l);
		return "/employee/manager/queryAll";
	}
	
	@GetMapping("queryName")
	public String queryName()
	{
		employee e=(employee) session.getAttribute("E");
		List<employee> l=employeemapper.queryName(e.getName());
		session.setAttribute("LP", l);
		return "/employee/manager/queryName";
	}
	
	/**********修改**************/
	@RequestMapping("managerUpdate")
	public String managerUpdate()
	{
		
		String Id=request.getParameter("id");
		String Name=request.getParameter("name");
		
		String Password=request.getParameter("password");
		String Type=request.getParameter("type");
		
		if(Id!=null && Id!="" && Name!=null && Name!=""
		  && Password!=null && Password!=""&& Type!=null && Type!="")
		{
			int a=Integer.parseInt(Id);
			int b=Integer.parseInt(Type);
			employee e=employeemapper.queryId(a);
			
			e.setName(Name);
			e.setPassword(Password);
			e.setType(b);
			employeemapper.update(e);
		}
		
		employee e=(employee) session.getAttribute("E");
		List<employee> l=employeemapper.queryAll();
		session.setAttribute("L", l);
		return "/employee/manager/managerUpdate";
	}
	
	/**********刪除**************/
	@RequestMapping("managerDelete")
	public String managerDelete()
	{
		String Id = request.getParameter("id");
	    

	    if (Id!=null && Id!="") {
	        int a = Integer.parseInt(Id);
	        employeemapper.delete(a);
	   
	    }
		    
		employee e=(employee) session.getAttribute("E");
		List<employee> l=employeemapper.queryAll();
		session.setAttribute("L", l);
		return "/employee/manager/managerDelete";
	}
	
	/**********一般員工資料**************/
	
	@GetMapping("employee")
	public String employee()
	{
		
		return "/employee/employee/employee";
	}
	
	/**********基本資料查詢**************/
	
	@GetMapping("employeeQueryName")
	public String employeeQueryName()
	{
		employee e=(employee) session.getAttribute("E");
		List<employee> l=employeemapper.queryName(e.getName());
		session.setAttribute("ELP", l);
		return "/employee/employee/employeeQueryName";
	}
	
	/**********修改**************/
	@RequestMapping("employeeUpdate")
	public String employeeUpdate()
	{
		
		String Id=request.getParameter("id");
		String Name=request.getParameter("name");
		
		String Password=request.getParameter("password");
		
		if(Id!=null && Id!="" && Name!=null && Name!=""
		  && Password!=null && Password!="")
		{
			int a=Integer.parseInt(Id);
			employee e=employeemapper.queryId(a);
			
			e.setName(Name);
			e.setPassword(Password);
			employeemapper.update(e);
		}
		
		employee e=(employee) session.getAttribute("E");
		List<employee> l=employeemapper.queryName(e.getName());
		
		session.setAttribute("L", l);
		
		return "/employee/employee/employeeUpdate";
		 
	}
}
