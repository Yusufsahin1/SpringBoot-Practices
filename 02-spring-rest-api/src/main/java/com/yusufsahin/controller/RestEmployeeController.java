package com.yusufsahin.controller;


import com.yusufsahin.model.Employee;
import com.yusufsahin.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/rest/api")
public class RestEmployeeController {

    @Autowired // Dependency Injection
    private EmployeeService employeeService;

    @GetMapping(path = "/employee-list") // http://localhost:8080/rest/api/employee-list
    public List<Employee> getAllEmployeeList(){
        return employeeService.getAllEmployeeList();
    }
}
