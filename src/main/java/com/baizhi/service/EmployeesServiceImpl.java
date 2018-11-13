package com.baizhi.service;

import com.baizhi.dao.EmployeesDAO;
import com.baizhi.entity.Employees;
import com.baizhi.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EmployeesServiceImpl implements EmployeesService {
	@Autowired
	private EmployeesDAO employeesDAO;
	@Override
	@Transactional(readOnly=true)
	public List<Employees> queryAllEmployees(Page page) {
		
		return employeesDAO.queryAllEmployees(page);
	}
	@Override
	public void insert(Employees employees) {
		employeesDAO.insert(employees);
		
	}
	@Override
	public void delete(Employees employees) {
		employeesDAO.delete(employees);
		
	}
	@Override
	public void update(Employees employees) {
		employeesDAO.update(employees);
	}
	@Override
	public Integer queryAllAmount() {

		return employeesDAO.queryAllAmount();
	}
	
}
