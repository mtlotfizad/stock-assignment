package com.lotfizad.stockassignment.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class StockDto {

    private long id;
    private String name;
    private double currentPrice;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate;

    public long getId() {
        return id;
    }

    public StockDto setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StockDto setName(String name) {
        this.name = name;
        return this;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public StockDto setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
        return this;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public StockDto setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    @Override
    public String toString() {
        return "StockDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentPrice=" + currentPrice +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
