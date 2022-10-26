package com.challengeturn2c.livecoding.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "vendedor")
public class SellerModel implements Serializable {



    private Long id;
    private String name;
    private List<CustomerModel> customers;

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
    public List<CustomerModel> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerModel> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "SellerModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", customerModel=" + customers +
                '}';
    }
}
