package com.lotfizad.stockassignment.api.viewModel;

public class CreateStockViewModel {

    private String name;
    private Double price;

    public String getName() {
        return name;
    }

    public CreateStockViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public CreateStockViewModel setPrice(Double price) {
        this.price = price;
        return this;
    }
}
