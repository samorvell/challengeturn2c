package com.turn2c.challenge.api.service;

import com.turn2c.challenge.api.model.SellerModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface SellerService {


    Optional<SellerModel> findSellerById(Long id);

    Optional<SellerModel> findSellerByName(String name);

    SellerModel save(SellerModel sellerModel);
}
