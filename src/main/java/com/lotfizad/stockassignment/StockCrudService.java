package com.lotfizad.stockassignment;

import com.lotfizad.stockassignment.domain.StockEntity;
import com.lotfizad.stockassignment.dto.CreateStockDto;
import com.lotfizad.stockassignment.exceptions.StockAlreadyExistsException;
import com.lotfizad.stockassignment.repository.StockRepository;
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
