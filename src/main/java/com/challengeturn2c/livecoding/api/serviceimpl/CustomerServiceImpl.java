package com.challengeturn2c.livecoding.api.serviceimpl;

import com.challengeturn2c.livecoding.api.Model.CustomerModel;
import com.challengeturn2c.livecoding.api.repository.CustomerRepository;
import com.challengeturn2c.livecoding.api.service.CustomerService;
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
    public Optional<CustomerModel> findCustomerById(Long Id) {
        log.info("Buscando cliente pelo Id {}", Id);
        return this.customerRepository.findById(Id);
    }

    @Override
    public CustomerModel save(CustomerModel customerModel) {
        log.info("Persistindo Cliente: {}", customerModel);
        return this.customerRepository.save(customerModel);

    }
}


