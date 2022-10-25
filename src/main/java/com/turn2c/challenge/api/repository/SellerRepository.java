package com.turn2c.challenge.api.repository;

import com.turn2c.challenge.api.model.SellerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface SellerRepository extends JpaRepository<SellerModel, Long> {

    @Transactional(readOnly = true)
    SellerModel findByName(String name);
}
