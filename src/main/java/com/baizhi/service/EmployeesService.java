package com.baizhi.service;

import com.baizhi.entity.Employees;
import com.baizhi.vo.Page;

import java.util.List;

public interface EmployeesService {
	List<Employees> queryAllEmployees(Page page);
	
	Integer queryAllAmount();
	
	void insert(Employees employees);
	
	void delete(Employees employees);
	
	void update(Employees employees);
}
