package com.lotfizad.stockassignment.api.viewModel;

public class UpdateStockPriceViewModel {
    private Double newPrice;

    public Double getNewPrice() {
        return newPrice;
    }

    public UpdateStockPriceViewModel setNewPrice(Double newPrice) {
        this.newPrice = newPrice;
        return this;
    }
}
