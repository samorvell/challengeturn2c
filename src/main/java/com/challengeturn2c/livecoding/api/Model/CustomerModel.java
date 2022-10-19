package com.challengeturn2c.livecoding.api.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cliente")
public class CustomerModel implements Serializable {

    private static final long serialVersionUID = 3960436649365666213L;


    private Long id;
    @Column(name = "nome", nullable = false)
    private String name;
    @Column(name = "vendedor", nullable = false)
    private List<SellerModel> sellerModels;

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
    public List<SellerModel> getSellerModels() {
        return sellerModels;
    }

    public void setSellerModels(List<SellerModel> sellerModels) {
        this.sellerModels = sellerModels;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", sellerModel=" + sellerModels +
                '}';
    }
}
