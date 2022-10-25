package com.turn2c.challenge.api.repository;

import com.turn2c.challenge.api.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
}
