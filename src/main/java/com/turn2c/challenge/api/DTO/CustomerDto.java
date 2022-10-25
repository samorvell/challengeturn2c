package com.turn2c.challenge.api.DTO;

import com.turn2c.challenge.api.model.SellerModel;

import java.util.List;

public class CustomerDto {

    private Long id;
    private String name;
    private String seller;
    private List<SellerModel> sellers;

    public CustomerDto(){

    }

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

    public List<SellerModel> getSellers() {
        return sellers;
    }

    public void setSellers(List<SellerModel> sellers) {
        this.sellers = sellers;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nomeVendedor='" + seller + '\'' +
                ", seller=" + sellers +
                '}';
    }
}
