package com.yusufsahin.controller;

import com.yusufsahin.dto.DtoCustomer;

public interface ICustomerController {

    public DtoCustomer findCustomerById(int id);
}
