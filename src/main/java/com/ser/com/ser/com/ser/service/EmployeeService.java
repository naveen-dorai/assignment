package com.ser.com.ser.com.ser.service;

import com.ser.com.ser.entity.Employee;
import com.ser.com.ser.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    //CREATE
    public void saveUsers(){
        Employee e1 = new Employee();
        e1.setEmpId(101);
        e1.setEmpName("Roger");
        e1.setGender("Male");
        e1.setDept("Finance");

        Employee e2 = new Employee();
        e2.setEmpId(102);
        e2.setEmpName("Sachin");
        e2.setGender("Male");
        e2.setDept("Finance");

        Employee e3 = new Employee();
        e3.setEmpId(103);
        e3.setEmpName("Steffi");
        e3.setGender("Female");
        e3.setDept("HR");

        Employee e4 = new Employee();
        e4.setEmpId(104);
        e4.setEmpName("Monica");
        e4.setGender("Female");
        e4.setDept("Admin");

        employeeRepo.save(e1);
        employeeRepo.save(e2);
        employeeRepo.save(e3);
        employeeRepo.save(e4);
        System.out.println("Saving users...");
    }


    //READ
    public Employee getEmployeeById(int id){
        System.out.println("Getting user by empId="+id);
        Optional<Employee> findById = employeeRepo.findById(id);
        Employee emp = null;
        if(findById.isPresent()) {
            emp = findById.get();
        }
        return emp;
    }

    //UPDATE
    public void updateEmployeeDept(int id, String dept){
        System.out.println("Updating user by empId="+id +". Dept="+dept);
        Optional<Employee> findById = employeeRepo.findById(id);
        Employee emp = null;
        if(findById.isPresent()) {
            emp = findById.get();
        }
        emp.setDept(dept);
        employeeRepo.save(emp);
    }

    //DELETE
    public void deleteByEmpId(int empId){
        System.out.println("Deleting record with empId:"+empId);
        employeeRepo.deleteById(empId);
    }


}
