package com.ser;

import com.ser.com.ser.com.ser.service.EmployeeService;
import com.ser.com.ser.entity.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JpaDemoAppApplication {

	public static void main(String[] args) {


		ConfigurableApplicationContext ctx = SpringApplication.run(JpaDemoAppApplication.class, args);
		EmployeeService employeeService = ctx.getBean(EmployeeService.class);

		//CREATE
		employeeService.saveUsers();

		//READ
		Employee emp = employeeService.getEmployeeById(101);
		System.out.println("emp="+emp);

		//UPDATE
		employeeService.updateEmployeeDept(101,"Admin");

		//DELETE
		employeeService.deleteByEmpId(104);
	}

}
