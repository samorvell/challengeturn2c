package com.challengeturn2c.livecoding.api.service;

import com.challengeturn2c.livecoding.api.Model.SellerModel;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface SellerService {

    Optional<SellerModel> findSellerById(Long id);

    SellerModel register(SellerModel sellerModel);
}
