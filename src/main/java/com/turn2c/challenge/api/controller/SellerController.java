package com.turn2c.challenge.api.controller;


import com.turn2c.challenge.api.DTO.SellerDto;
import com.turn2c.challenge.api.DTO.CustomerRegisterDto;
import com.turn2c.challenge.api.model.CustomerModel;
import com.turn2c.challenge.api.model.SellerModel;
import com.turn2c.challenge.api.response.Response;
import com.turn2c.challenge.api.service.CustomerService;
import com.turn2c.challenge.api.service.SellerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
public class SellerController {

    private static final Logger log = LoggerFactory.getLogger(SellerController.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SellerService sellerService;

    public SellerController() {
    }

    @GetMapping(value = "/seller/{id}")
    public ResponseEntity<Response<SellerDto>> findSellerById(@PathVariable("id") Long id) {

        log.info("Buscando vendedor por ID: {}", id);
        Response<SellerDto> response = new Response<SellerDto>();
        Optional<SellerModel> seller = this.sellerService.findSellerById(id);

        if (!seller.isPresent()) {
            log.info("Vendedor não encontrado para o ID: {}", id);
            response.getErrors().add("Vendedor não encontrado para o id " + id);
            return ResponseEntity.badRequest().body(response);
        }


        response.setData(this.convertToDtoClient(seller.get()));
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/registerseller")
    public ResponseEntity<Response<SellerDto>> register(@Valid @RequestBody SellerDto sellerDto,
                                                         BindingResult result) throws NoSuchAlgorithmException {
        log.info("Cadastrando vendedor: {}", sellerDto.toString());
        Response<SellerDto> response = new Response<SellerDto>();

        SellerModel sellerModel = this.convertDtoToSeller(sellerDto, result);

        if (result.hasErrors()) {
            log.error("Erro na validação dos dados de cadastro do vendedor: {}", result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        this.sellerService.save(sellerModel);

        response.setData(this.convertRegisterDtoToSeller(sellerModel));
        return ResponseEntity.ok(response);
    }


    private SellerDto convertToDtoClient(SellerModel sellerModel) {
        SellerDto sellerDto = new SellerDto();
        sellerDto.setId(sellerModel.getId());
        sellerDto.setName(sellerModel.getName());
        sellerDto.setCustomerModels(sellerModel.getCustomerModel());

        return sellerDto;
    }

    private SellerDto convertRegisterDtoToSeller(SellerModel sellerModel) {
        SellerDto sellerDto = new SellerDto();
        sellerDto.setId(sellerModel.getId());
        sellerDto.setName(sellerModel.getName());
        sellerDto.setCustomerModels(sellerModel.getCustomerModel());

        return sellerDto;
    }


    private SellerModel convertDtoToSeller(SellerDto sellerDto, BindingResult result)
            throws NoSuchAlgorithmException {
        SellerModel sellerModel = new SellerModel();
        sellerModel.setName(sellerDto.getName());
        sellerModel.setCustomerModel(sellerDto.getCustomerModels());


        return sellerModel;
    }

}
