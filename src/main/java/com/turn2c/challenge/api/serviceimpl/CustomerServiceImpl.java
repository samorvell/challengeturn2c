package com.turn2c.challenge.api.serviceimpl;

import com.turn2c.challenge.api.model.CustomerModel;
import com.turn2c.challenge.api.repository.CustomerRepository;
import com.turn2c.challenge.api.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Optional<CustomerModel> findCustomerById(Long id) {
        log.info("Buscando cliente pelo id {}", id);
        return Optional.ofNullable(customerRepository.getById(id));
    }

    @Override
    public CustomerModel save(CustomerModel customerModel) {
        log.info("Salvando cliente: {}", customerModel);
        return this.customerRepository.save(customerModel);
    }
}
