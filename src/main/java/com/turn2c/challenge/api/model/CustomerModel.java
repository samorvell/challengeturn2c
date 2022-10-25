package com.turn2c.challenge.api.model;

import javax.persistence.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cliente")
public class CustomerModel implements Serializable {


    private Long id;
    private String name;
    private List<SellerModel> sellerModel;


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
    public List<SellerModel> getSellerModel() {
        return sellerModel;
    }

    public void setSellerModel(List<SellerModel> sellerModel) {
        this.sellerModel = sellerModel;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sellerModel=" + sellerModel +
                '}';
    }
}
