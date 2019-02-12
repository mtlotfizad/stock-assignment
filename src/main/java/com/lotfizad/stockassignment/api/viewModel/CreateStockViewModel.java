package com.lotfizad.stockassignment.api.viewModel;

import javax.validation.constraints.NotNull;

public class CreateStockViewModel {

    @NotNull
    private String name;
    @NotNull
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
