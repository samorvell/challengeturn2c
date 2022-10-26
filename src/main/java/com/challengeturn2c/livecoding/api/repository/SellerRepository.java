package com.challengeturn2c.livecoding.api.repository;

import com.challengeturn2c.livecoding.api.model.SellerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface SellerRepository extends JpaRepository<SellerModel, Long> {

    @Transactional(readOnly = true)
    SellerModel findByName(String name);
}
