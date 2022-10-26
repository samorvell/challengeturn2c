package com.challengeturn2c.livecoding.api.serviceimpl;

import com.challengeturn2c.livecoding.api.model.SellerModel;
import com.challengeturn2c.livecoding.api.repository.SellerRepository;
import com.challengeturn2c.livecoding.api.service.SellerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {

    private static final Logger log = LoggerFactory.getLogger(SellerServiceImpl.class);

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public Optional<SellerModel> findSellerById(Long id) {
        log.info("Buscando vendedor pelo id {}", id);
        return this.sellerRepository.findById(id);
    }

    @Override
    public Optional<SellerModel> findSellerByName(String name) {
        log.info("Buscando vendedor pelo nome {}", name);
        return Optional.ofNullable(sellerRepository.findByName(name));
    }

    @Override
    public SellerModel save(SellerModel sellerModel) {
        log.info("Registrando vendedor: {}", sellerModel);
        return this.sellerRepository.save(sellerModel);
    }
}
