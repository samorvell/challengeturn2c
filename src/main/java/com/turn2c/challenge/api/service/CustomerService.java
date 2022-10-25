package com.turn2c.challenge.api.service;

import com.turn2c.challenge.api.model.CustomerModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CustomerService {
    Optional<CustomerModel> findCustomerById(Long id);

    CustomerModel save(CustomerModel customerModel);
}
