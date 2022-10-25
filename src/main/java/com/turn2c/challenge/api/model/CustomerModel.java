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
    private String sellerName;
    private List<SellerModel> sellers;


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
    public List<SellerModel> getSellers() {
        return sellers;
    }

    public void setSellers(List<SellerModel> sellers) {
        this.sellers = sellers;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sellerName='" + sellerName + '\'' +
                ", sellers=" + sellers +
                '}';
    }
}
