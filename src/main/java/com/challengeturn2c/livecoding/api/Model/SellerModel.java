package com.challengeturn2c.livecoding.api.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vendedor")
public class SellerModel implements Serializable {

    private static final long serialVersionUID = 6524560251526772839L;

    private Long Id;
    @Column(name = "nome", nullable = false)
    private String name;
    @Column(name = "cliente", nullable = false)
    private Set<CustomerModel> customerModels;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<CustomerModel> getCustomerModels() {
        return customerModels;
    }

    public void setCustomerModels(List<CustomerModel> customerModels) {
        this.customerModels = customerModels;
    }

    @Override
    public String toString() {
        return "SellerModel{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", customerModel=" + customerModels +
                '}';
    }
}
