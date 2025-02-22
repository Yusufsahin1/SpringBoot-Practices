package com.yusufsahin.services;

import com.yusufsahin.dto.DtoCustomer;

public interface ICustomerService {

    public DtoCustomer findCustomerById(int id);
}
