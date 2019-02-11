package com.lotfizad.stockassignment.service;

import com.lotfizad.stockassignment.repository.StockRepository;
import com.lotfizad.stockassignment.repository.domain.StockEntity;
import com.lotfizad.stockassignment.service.dto.CreateStockDto;
import com.lotfizad.stockassignment.service.exceptions.StockAlreadyExistsException;
import org.springframework.stereotype.Service;

@Service
public class StockCrudService {

    private final StockRepository stockRepository;

    public StockCrudService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Long createStock(CreateStockDto createStockDto) {
        String stockName = createStockDto.getName();
        StockEntity existedStock = stockRepository.findByName(stockName);
        if (existedStock != null)
            throw new StockAlreadyExistsException(
                    String.format("Stock with stock name %s is already defined.", createStockDto.getName()));

        StockEntity stockEntity = new StockEntity()
                .setName(stockName)
                .setCurrentPrice(createStockDto.getPrice());
        return stockRepository.save(stockEntity).getId();
    }
}
