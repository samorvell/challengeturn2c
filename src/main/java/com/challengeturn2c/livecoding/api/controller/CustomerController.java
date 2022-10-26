package com.challengeturn2c.livecoding.api.controller;


import com.challengeturn2c.livecoding.api.DTO.CustomerDto;
import com.challengeturn2c.livecoding.api.model.CustomerModel;
import com.challengeturn2c.livecoding.api.model.SellerModel;
import com.challengeturn2c.livecoding.api.service.CustomerService;
import com.challengeturn2c.livecoding.api.service.SellerService;
import com.challengeturn2c.livecoding.api.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Response<CustomerDto>> registerCustomer(@RequestBody CustomerDto customerDto,
                                                                   BindingResult result) throws NoSuchAlgorithmException {
        log.info("Cadastrando cliente: {}", customerDto.toString());
        Response<CustomerDto> response = new Response<CustomerDto>();

        CustomerModel customerModel = this.convertDtoToClient(customerDto, result);

        if (result.hasErrors()) {
            log.error("Erro validando dados de cadastro cliente: {}", result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        Optional<SellerModel> seller = this.sellerService.findSellerByName(customerDto.getName());
        seller.ifPresent(sel -> customerModel.setSellers((List<SellerModel>) sel));

        this.customerService.save(customerModel);

        response.setData(this.convertRegisterDtoToCustomer(customerModel));
        return ResponseEntity.ok(response);
    }


    private CustomerDto convertToDtoClient(CustomerModel customerModel) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customerModel.getId());
        customerDto.setName(customerModel.getName());
        customerDto.setSeller(customerModel.getSellerName());

        return customerDto;
    }

    private CustomerDto convertRegisterDtoToCustomer(CustomerModel customerModel) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customerModel.getId());
        customerDto.setName(customerModel.getName());
        customerDto.setSellers(customerModel.getSellers());

        return customerDto;
    }


    private CustomerModel convertDtoToClient(CustomerDto customerDto, BindingResult result)
            throws NoSuchAlgorithmException {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setName(customerDto.getName());
        customerModel.setSellerName(customerDto.getSeller());
        customerModel.setSellers(customerDto.getSellers());


        return customerModel;
    }

}
