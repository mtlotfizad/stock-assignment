package com.lotfizad.stockassignment.exceptions;

public class StockAlreadyExistsException extends RuntimeException {

    public StockAlreadyExistsException(String message) {
        super(message);
    }
}
