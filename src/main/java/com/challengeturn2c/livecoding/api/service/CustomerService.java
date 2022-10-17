package com.challengeturn2c.livecoding.api.service;

import com.challengeturn2c.livecoding.api.Model.CustomerModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CustomerService {

    Optional<CustomerModel> findCustomerById(Long Id);


    CustomerModel save(CustomerModel customerModel);
}
