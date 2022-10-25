package com.turn2c.challenge.api.DTO;

import com.turn2c.challenge.api.model.SellerModel;

import java.util.List;

public class CustomerRegisterDto {

    private Long id;
    private String nome;
    private String nomeVendedor;
    private List <SellerModel> seller;

    public CustomerRegisterDto(){

    }

    public CustomerRegisterDto(Long id, String nome, String nomeVendedor, List<SellerModel> seller) {
        this.id = id;
        this.nome = nome;
        this.nomeVendedor = nomeVendedor;
        this.seller = seller;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<SellerModel> getSeller() {
        return seller;
    }

    public void setSeller(List<SellerModel> seller) {
        this.seller = seller;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    @Override
    public String toString() {
        return "CustomerRegisterDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nomeVendedor='" + nomeVendedor + '\'' +
                ", seller=" + seller +
                '}';
    }
}
