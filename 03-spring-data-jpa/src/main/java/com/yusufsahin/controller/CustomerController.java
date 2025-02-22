package com.yusufsahin.controller;

import com.yusufsahin.dto.DtoCustomer;
import com.yusufsahin.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "rest/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/list/{id}")
    public DtoCustomer findCustomerById(@PathVariable(name = "id") int id) {
        return customerService.findCustomerById(id);
    }
}
