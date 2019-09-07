package com.wx.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.wx.spring.bean.Employee;
import com.wx.spring.dao.EmployeeDao;

class JdbcTest01 {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
	NamedParameterJdbcTemplate nameJdbcTemplate = ioc.getBean(NamedParameterJdbcTemplate.class);
	@Test
	void test() throws SQLException {
		//实验1：测试连接源
		DataSource bean = ioc.getBean(DataSource.class);
		Connection connection = bean.getConnection();
		System.out.println(connection);
		connection.close();
		
	}
	@Test
	void test02() {
		//实验2：将emp_id = 5的记录的salary字段更新为1300.00
		String sql = "update employee SET salary = ? where emp_id = ?";
		int update = jdbcTemplate.update(sql,1300.00,5);
		System.out.println(update);
	}
	
	@Test
	void test03() {
		//实验3：批量插入
		String sql = "insert into employee(emp_name,salary) value (?,?)";
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[] {"张三",1998.98});
		batchArgs.add(new Object[] {"李四",2998.98});
		batchArgs.add(new Object[] {"王五",3998.98});
		int[] batchUpdate = jdbcTemplate.batchUpdate(sql, batchArgs);
		for (int i : batchUpdate) {
			System.out.println(i);
		}
	}
	
	@Test
	void test04() {
		//实验4：查询emp_id = 5的数据库记录，封装为一个java对象返回
		//javaBean需要和数据库字ｓ段名一致，否则无法封装，起别名即可。
		//查询集合:jdbcTemplate.query()
		//查询单个对象:jdbcTemplate.queryForObject()
		//如果查询没结果就会报错
		String sql = "select emp_id empID,emp_name empName,salary from employee where emp_id = ?";
		//rowMapper：每一行与javaBean的属性如何映射
		Employee queryForObject = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), 5);
		System.out.println(queryForObject);
		//实验5：查询salary>4000的数据库记录，封装为List集合返回
		
		sql = "select * from employee";
		List<Employee> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
		for (Employee employee : query) {
			System.out.println(employee);
		}
	}
	
	@Test
	void test05() {
		//实验5：查询salary>4000的数据库记录，封装为List集合返回
		String sql = "select emp_id empID,emp_name empName,salary from employee where salary>?";
		List<Employee> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class),4000);
		for (Employee employee : query) {
			System.out.println(employee);
		}
		//实验6：查询最大的salary
		sql = "select Max(salary) from employee;";
		Double queryForObject = jdbcTemplate.queryForObject(sql, Double.class);
		System.out.println(queryForObject);
	}
	
	@Test
	void test06() {
		//实验7：使用带有具名参数的SQL语句插入一条员工记录，并以Map形式传入参数值
		/*
		 * 具名参数：剧透名字的参数，参数不是占位符了，而是一个变量名
		 * 			:参数名
		 * 占位符参数：？的顺序不能乱，传参注意。
		 */
		String sql = "insert into employee(emp_name,salary) values (:empName,:salary)";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("empName", "逗你妹");
		map.put("salary", 8888.0);
		int update = nameJdbcTemplate.update(sql, map);
		System.out.println(update);
	}
	
	@Test
	void test07() {
		//实验8：重复试验7，以SqlParameterSource形式传入参数值
		//这里的具名参数需要和JavaBean里的名字一致
		String sql = "insert into employee(emp_name,salary) values (:empName,:salary)";
		Employee employee = new Employee();
		employee.setEmpName("逗你妹哈哈哈");
		employee.setSalary(777.7);
		int update = nameJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(employee));
		System.out.println(update);
	}
	
	@Test
	void test08() {
		//实验9：创建BookDao，自动装配JdbcTemplate
		EmployeeDao bean = ioc.getBean(EmployeeDao.class);
		int saveEmployee = bean.saveEmployee(new Employee("王二傻", 753159.5));
		if(saveEmployee>0)
			System.out.println("插入成功");
		else
			System.out.println("插入失败");
	}
	
}
