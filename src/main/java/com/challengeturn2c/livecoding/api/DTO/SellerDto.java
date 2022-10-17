package com.challengeturn2c.livecoding.api.DTO;

public class SellerDto {

    private Long Id;
    private String name;

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

    @Override
    public String toString() {
        return "SellerDto{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }
}
