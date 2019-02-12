package com.lotfizad.stockassignment.api;


import com.lotfizad.stockassignment.api.mapper.CreateStockViewModelMapper;
import com.lotfizad.stockassignment.api.viewModel.CreateStockViewModel;
import com.lotfizad.stockassignment.service.StockCrudService;
import com.lotfizad.stockassignment.service.dto.CreateStockDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/api/stocks")
public class StockController {

    private final StockCrudService stockCrudService;
    private final CreateStockViewModelMapper createStockViewModelMapper;

    public StockController(StockCrudService stockCrudService, CreateStockViewModelMapper createStockViewModelMapper) {
        this.stockCrudService = stockCrudService;
        this.createStockViewModelMapper = createStockViewModelMapper;
    }

    @PostMapping
    public ResponseEntity<Long> createNewStock(@Valid @RequestBody CreateStockViewModel createStock) {
        CreateStockDto createStockDto = createStockViewModelMapper.fromViewModelToDto(createStock);
        return ok().body(stockCrudService.createStock(createStockDto));
    }

    @GetMapping
    public ResponseEntity<Page> listStocks(Pageable pageable) {
        return ok().body(stockCrudService.listAll(pageable));
    }


}
