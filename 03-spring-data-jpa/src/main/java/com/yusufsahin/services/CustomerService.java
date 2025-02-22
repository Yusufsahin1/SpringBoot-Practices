package com.yusufsahin.services;

import com.yusufsahin.dto.DtoAddress;
import com.yusufsahin.dto.DtoCustomer;
import com.yusufsahin.entities.Address;
import com.yusufsahin.entities.Customer;
import com.yusufsahin.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public DtoCustomer findCustomerById(int id) {

        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();

        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isPresent()) {
            Customer customer = optional.get();
            Address address = optional.get().getAddress();

            BeanUtils.copyProperties(customer, dtoCustomer);
            BeanUtils.copyProperties(address, dtoAddress);

            dtoCustomer.setDtoAddress(dtoAddress);

            return dtoCustomer;
        }
        else
            return null;
    }
}
