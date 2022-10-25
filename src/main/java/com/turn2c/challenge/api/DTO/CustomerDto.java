package com.turn2c.challenge.api.DTO;

import com.turn2c.challenge.api.model.SellerModel;

import java.util.List;

public class CustomerDto {

    private Long id;
    private String name;
    private List<SellerModel> seller;

    public CustomerDto(){

    }

    public CustomerDto(Long id, String name, List<SellerModel> seller) {
        this.id = id;
        this.name = name;
        this.seller = seller;
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

    public List<SellerModel> getSeller() {
        return seller;
    }

    public void setSeller(List<SellerModel> seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "CustomerRegisterDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seller='" + seller + '\'' +
                '}';
    }
}
