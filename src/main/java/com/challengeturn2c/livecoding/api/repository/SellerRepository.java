package com.challengeturn2c.livecoding.api.repository;

import com.challengeturn2c.livecoding.api.Model.CustomerModel;
import com.challengeturn2c.livecoding.api.Model.SellerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface SellerRepository extends JpaRepository<SellerModel, Long> {
    @Transactional(readOnly = true)
    SellerModel findSellerByName(String name);
}
