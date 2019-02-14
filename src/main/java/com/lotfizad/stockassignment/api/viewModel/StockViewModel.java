package com.lotfizad.stockassignment.api.viewModel;

import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

public class StockViewModel {
    private long id;
    private String name;
    private double currentPrice;
    private String lastUpdate;

    public long getId() {
        return id;
    }

    public StockViewModel setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StockViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public StockViewModel setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
        return this;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public StockViewModel setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }
}
