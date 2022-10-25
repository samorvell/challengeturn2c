package com.turn2c.challenge.api.DTO;

import com.turn2c.challenge.api.model.CustomerModel;
import com.turn2c.challenge.api.model.SellerModel;

import java.util.List;

public class SellerDto {

    private Long Id;
    private String name;
    private List<CustomerModel> customerModels;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CustomerModel> getCustomerModels() {
        return customerModels;
    }

    public void setCustomerModels(List<CustomerModel> customerModels) {
        this.customerModels = customerModels;
    }

    @Override
    public String toString() {
        return "SellerDto{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", customerModels=" + customerModels +
                '}';
    }
}
