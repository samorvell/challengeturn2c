package com.challengeturn2c.livecoding.api.Model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

public class CustomerModel implements Serializable {

    private static final long serialVersionUID = 3960436649365666213L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;
    @Column(name = "nome", nullable = false)
    private String name;
    private List<SellerModel> sellerModel;

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

    public List<SellerModel> getSellerModel() {
        return sellerModel;
    }

    public void setSellerModel(List<SellerModel> sellerModel) {
        this.sellerModel = sellerModel;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", sellerModel=" + sellerModel +
                '}';
    }
}
