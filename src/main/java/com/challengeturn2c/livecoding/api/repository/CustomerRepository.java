package com.challengeturn2c.livecoding.api.repository;

import com.challengeturn2c.livecoding.api.Model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

    @Transactional(readOnly = true)
    CustomerModel findByName(String name);

}
