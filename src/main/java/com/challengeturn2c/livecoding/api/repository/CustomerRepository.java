package com.challengeturn2c.livecoding.api.repository;

import com.challengeturn2c.livecoding.api.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
}
