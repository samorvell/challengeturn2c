package com.challengeturn2c.livecoding.api.serviceimpl;


import com.challengeturn2c.livecoding.api.Model.SellerModel;
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
    private SellerRepository sellerRepository;



    @Override
    public Optional<SellerModel> findSellerById(Long id) {
        log.info("Buscando vendedor pelo Id {}", id);
        return this.sellerRepository.findById(id);
    }

    @Override
    public SellerModel register(SellerModel sellerModel) {
        log.info("Persistindo Vendedor: {}", sellerModel);
        return this.sellerRepository.save(sellerModel);
    }
}
