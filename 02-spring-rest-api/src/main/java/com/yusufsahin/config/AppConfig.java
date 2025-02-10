package com.yusufsahin.config;


import com.yusufsahin.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> employeeList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1", "Yusuf", "Şahin"));
        employeeList.add(new Employee("2", "Bayram", "Özcan"));
        employeeList.add(new Employee("3", "Muhammet", "Kaya"));
        employeeList.add(new Employee("4", "Enes", "Bayram"));
        employeeList.add(new Employee("5", "Yusuf", "Şahinoğlu"));

        return employeeList;
    }
}
