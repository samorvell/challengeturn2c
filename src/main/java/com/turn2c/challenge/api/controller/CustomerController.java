package com.turn2c.challenge.api.controller;


import com.turn2c.challenge.api.DTO.CustomerDto;
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
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SellerService sellerService;

    public CustomerController(){
    }

    @GetMapping(value = "/customer/{id}")
    public ResponseEntity<Response<CustomerDto>> findCustomerById(@PathVariable("id") Long id) {

        log.info("Buscando cliente por ID: {}", id);
        Response<CustomerDto> response = new Response<CustomerDto>();
        Optional<CustomerModel> customer = this.customerService.findCustomerById(id);

        if (!customer.isPresent()) {
            log.info("Cliente não encontrado para o ID: {}", id);
            response.getErrors().add("Funcionário não encontrado para o id " + id);
            return ResponseEntity.badRequest().body(response);
        }


        response.setData(this.convertToDtoClient(customer.get()));
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/registercustomer")
    public ResponseEntity<Response<CustomerRegisterDto>> registerCustomer(@RequestBody CustomerRegisterDto customerRegisterDto,
                                                                   BindingResult result) throws NoSuchAlgorithmException {
        log.info("Cadastrando cliente: {}", customerRegisterDto.toString());
        Response<CustomerRegisterDto> response = new Response<CustomerRegisterDto>();

        CustomerModel customerModel = this.convertDtoToClient(customerRegisterDto, result);

        if (result.hasErrors()) {
            log.error("Erro validando dados de cadastro cliente: {}", result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        Optional<SellerModel> seller = this.sellerService.findSellerByName(customerRegisterDto.getName());
        seller.ifPresent(sel -> customerModel.setSellerModel((List<SellerModel>) sel));

        this.customerService.save(customerModel);

        response.setData(this.convertRegisterDtoToCustomer(customerModel));
        return ResponseEntity.ok(response);
    }


    private CustomerDto convertToDtoClient(CustomerModel customerModel) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customerModel.getId());
        customerDto.setName(customerModel.getName());

        return customerDto;
    }

    private CustomerRegisterDto convertRegisterDtoToCustomer(CustomerModel customerModel) {
        CustomerRegisterDto customerRegisterDto = new CustomerRegisterDto();
        customerRegisterDto.setId(customerModel.getId());
        customerRegisterDto.setName(customerModel.getName());
        customerRegisterDto.setSeller(customerModel.getSellerModel());

        return customerRegisterDto;
    }


    private CustomerModel convertDtoToClient(CustomerRegisterDto customerRegisterDto, BindingResult result)
            throws NoSuchAlgorithmException {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setName(customerRegisterDto.getName());
        customerModel.setSellerModel(customerRegisterDto.getSeller());


        return customerModel;
    }

}
