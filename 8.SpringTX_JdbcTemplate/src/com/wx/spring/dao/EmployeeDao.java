package com.wx.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wx.spring.bean.Employee;

@Repository
public class EmployeeDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	public int saveEmployee(Employee employee) {
		String sql = "insert into employee(emp_name,salary) values (?,?)";
		return jdbcTemplate.update(sql, employee.getEmpName(),employee.getSalary());
	}
}
