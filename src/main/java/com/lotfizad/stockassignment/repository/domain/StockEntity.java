package com.lotfizad.stockassignment.repository.domain;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="stock")
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double currentPrice;
    @UpdateTimestamp
    private Date lastUpdate;

    public long getId() {
        return id;
    }

    public StockEntity setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StockEntity setName(String name) {
        this.name = name;
        return this;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public StockEntity setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
        return this;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public StockEntity setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    @Override
    public String toString() {
        return String.format(
                "Stock[id=%d, name='%s', price='%f']",
                id, name, currentPrice);
    }
}
