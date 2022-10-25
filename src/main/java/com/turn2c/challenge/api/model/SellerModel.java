package com.turn2c.challenge.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "vendedor")
public class SellerModel implements Serializable {



    private Long id;
    private String name;
    private List<CustomerModel> customerModel;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<CustomerModel> getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(List<CustomerModel> customerModel) {
        this.customerModel = customerModel;
    }

    @Override
    public String toString() {
        return "SellerModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", customerModel=" + customerModel +
                '}';
    }
}
