package com.challengeturn2c.livecoding.api.controller;

import com.challengeturn2c.livecoding.api.DTO.CustomerDto;
import com.challengeturn2c.livecoding.api.DTO.CustomerRegisterDto;
import com.challengeturn2c.livecoding.api.Model.CustomerModel;
import com.challengeturn2c.livecoding.api.response.Response;
import com.challengeturn2c.livecoding.api.service.CustomerService;
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
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    public CustomerController(){
    }

    /**
     * Retorna uma cliente dado um ID.
     *
     * @param id
     * @return ResponseEntity<Response<CustomerDto>>
     */
    @GetMapping(value = "customer/{id}")
    public ResponseEntity<Response<CustomerDto>> buscarEmpresaPorId(@PathVariable("id") Long id) {
        log.info("Buscando cliente por Id: {}", id);
        Response<CustomerDto> response = new Response<CustomerDto>();
        Optional<CustomerModel> customer = customerService.findCustomerById(id);

        if (!customer.isPresent()) {
            log.info("Cliente não encontrado para o Id: {}", id);
            response.getErrors().add("Cliente não encontrado para o Id " + id);
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(this.converterCustomerDto(customer.get()));
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "registerCustomer/{id}")
    public ResponseEntity<Response<CustomerRegisterDto>> cadastrar(@Valid @RequestBody CustomerRegisterDto customerRegisterDto,
                                                                   BindingResult result) throws NoSuchAlgorithmException {
        log.info("Cadastrando cliente: {}", customerRegisterDto.toString());
        Response<CustomerRegisterDto> response = new Response<CustomerRegisterDto>();

        CustomerModel customer = this.convertDtoToEmployee(customerRegisterDto, result);

        if (result.hasErrors()) {
            log.error("Erro validando dados de cadastro cliente: {}", result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        Optional<CustomerModel> customerModel = this.customerService.findCustomerById(customerRegisterDto.getId());

        this.customerService.save(customer);
        
        return ResponseEntity.ok(response);
    }



    private CustomerDto converterCustomerDto(CustomerModel customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());

        return customerDto;
    }

    private CustomerModel convertDtoToEmployee(CustomerRegisterDto customerRegisterDto, BindingResult result)
            throws NoSuchAlgorithmException {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setId(customerRegisterDto.getId());
        customerModel.setName(customerRegisterDto.getName());

        return customerModel;
    }


}
