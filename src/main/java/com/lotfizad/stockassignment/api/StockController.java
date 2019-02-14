package com.lotfizad.stockassignment.api;


import com.lotfizad.stockassignment.api.mapper.CreateStockViewModelMapper;
import com.lotfizad.stockassignment.api.viewModel.CreateStockViewModel;
import com.lotfizad.stockassignment.api.viewModel.UpdateStockPriceViewModel;
import com.lotfizad.stockassignment.service.StockCrudService;
import com.lotfizad.stockassignment.service.dto.CreateStockDto;
import com.lotfizad.stockassignment.service.dto.StockDto;
import com.lotfizad.stockassignment.service.exceptions.StockAlreadyExistsException;
import com.lotfizad.stockassignment.service.exceptions.StockNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

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

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createNewStock(@Valid @RequestBody CreateStockViewModel createStock) {
        CreateStockDto createStockDto = createStockViewModelMapper.fromViewModelToDto(createStock);
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(stockCrudService.createStock(createStockDto));
        } catch (StockAlreadyExistsException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Page> listStocks(Pageable pageable) {
        Page<StockDto> pagedStocks = stockCrudService.listAll(pageable);
        return ok().body(pagedStocks);
    }

    @GetMapping("/{stockId}")
    public ResponseEntity getOneStock(@PathVariable Long stockId) {
        try {
            return ok().body(stockCrudService.fetchOne(stockId));
        } catch (StockNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @PutMapping(path = "/{stockId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updatePrice(@PathVariable Long stockId, @RequestBody UpdateStockPriceViewModel updateParams) {
        try {
            stockCrudService.updatePrice(stockId, updateParams.getNewPrice());
            return ok().body(String.format("Stock %d updated successfully.", stockId));
        } catch (StockNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }


}
