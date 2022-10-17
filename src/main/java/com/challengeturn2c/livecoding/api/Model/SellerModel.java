package com.challengeturn2c.livecoding.api.Model;

import java.io.Serializable;
import java.util.List;

public class SellerModel implements Serializable {

    private Long Id;
    private String name;
    private List<CustomerModel> customerModel;

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

    public List<CustomerModel> getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(List<CustomerModel> customerModel) {
        this.customerModel = customerModel;
    }

    @Override
    public String toString() {
        return "SellerModel{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", customerModel=" + customerModel +
                '}';
    }
}
