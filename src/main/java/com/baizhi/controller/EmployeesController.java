package com.baizhi.controller;

import com.baizhi.entity.Employees;
import com.baizhi.service.EmployeesService;
import com.baizhi.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/employees")

public class EmployeesController {
	@Autowired
	private EmployeesService employeesService;
	@RequestMapping("/showAllEmployees")
	public String showAllEmployees(HttpServletRequest request,Page page){
		List<Employees> queryAllEmployees = employeesService.queryAllEmployees(page);
		List<Integer> pageN=new ArrayList<Integer>();
		Integer a = employeesService.queryAllAmount();
		page.setAllTotal(a);
		int allPage = page.getAllPage();
		for(int i=1;i<=allPage;i++){
			pageN.add(i);
		}
		request.setAttribute("pageAmount", pageN);
		request.setAttribute("queryAllEmployees", queryAllEmployees);
		request.setAttribute("page1", page.getPageNum());
		return "/ems1.0/emplists";
	}
	@RequestMapping("/delete")
	public String deleteEmployees(Employees employees,Integer pageNum){
		employeesService.delete(employees);
		return "forward:/employees/showAllEmployees?pageNum="+pageNum;
	}
	
	@RequestMapping("/update")
	public String updateEmployees(Employees employees){
		employeesService.update(employees);
		return "redirect:/employees/showAllEmployees?pageNum=1";
	}
	@RequestMapping("/insert")
	public String insertEmployees(Employees employees){
		employeesService.insert(employees);
		return "redirect:/employees/showAllEmployees?pageNum=1";
	}
}
