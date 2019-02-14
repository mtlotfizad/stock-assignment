package com.lotfizad.stockassignment.service.exceptions;

public class StockNotFoundException extends RuntimeException {
    public StockNotFoundException(String s) {
        super(s);
    }
}
