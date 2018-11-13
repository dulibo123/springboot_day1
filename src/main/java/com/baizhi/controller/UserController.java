package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/register")
	public String register(User user,HttpServletRequest request,String number){
		String code = (String) request.getSession().getAttribute("validationCode");
		if(code.equals(number)){
		userService.insert(user);
		return "redirect:/ems1.0/login.jsp";
		}
		return "redirect:/ems1.0/register.jsp";
	}
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest request){
		HttpSession session = request.getSession();
		User users = userService.query(user);
		if(users!=null){
			session.setAttribute("users", users);
			return "redirect:/employees/showAllEmployees?pageNum=1";
		}
		else
			return "redirect:/ems1.0/login.jsp";
	}
}
