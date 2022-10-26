package com.challengeturn2c.livecoding.api.service;

import com.challengeturn2c.livecoding.api.model.SellerModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface SellerService {


    Optional<SellerModel> findSellerById(Long id);

    Optional<SellerModel> findSellerByName(String name);

    SellerModel save(SellerModel sellerModel);
}
