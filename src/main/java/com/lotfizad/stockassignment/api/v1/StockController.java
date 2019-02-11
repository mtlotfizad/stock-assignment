package com.lotfizad.stockassignment.api.v1;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/stocks")
public class StockController {

    @GetMapping
    public String getStockLists() {
        return "haha";
    }
}
