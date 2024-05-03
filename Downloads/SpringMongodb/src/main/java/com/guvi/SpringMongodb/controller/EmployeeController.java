package com.guvi.SpringMongodb.controller;

import com.guvi.SpringMongodb.entity.Employee;
import com.guvi.SpringMongodb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/addEmployee")
    public String showAddEmployeeForm() {
        return "addEmployee";
    }



    @PostMapping("/addEmployee")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @GetMapping("/displayAll")
    public List<Employee> displayAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/display/{id}")
    public Employee displayEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }
}


