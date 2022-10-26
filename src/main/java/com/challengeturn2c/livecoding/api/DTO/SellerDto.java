package com.challengeturn2c.livecoding.api.DTO;

import com.challengeturn2c.livecoding.api.model.CustomerModel;

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
