package com.lotfizad.stockassignment.service.dto;

public class CreateStockDto {

    private String name;
    private Double price;

    public String getName() {
        return name;
    }

    public CreateStockDto setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public CreateStockDto setPrice(Double price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return "CreateStockDto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
