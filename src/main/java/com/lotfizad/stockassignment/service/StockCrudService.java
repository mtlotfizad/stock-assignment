package com.lotfizad.stockassignment.service;

import com.lotfizad.stockassignment.repository.StockRepository;
import com.lotfizad.stockassignment.repository.domain.StockEntity;
import com.lotfizad.stockassignment.service.dto.CreateStockDto;
import com.lotfizad.stockassignment.service.dto.StockDto;
import com.lotfizad.stockassignment.service.exceptions.StockAlreadyExistsException;
import com.lotfizad.stockassignment.service.mapper.StockEntityToDtoMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class StockCrudService {

    private final StockRepository stockRepository;
    private final StockEntityToDtoMapper stockEntityToDtoMapper;

    public StockCrudService(StockRepository stockRepository, StockEntityToDtoMapper stockEntityToDtoMapper) {
        this.stockRepository = stockRepository;
        this.stockEntityToDtoMapper = stockEntityToDtoMapper;
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

    public Page<StockDto> listAll(Pageable pageable) {
        Page<StockEntity> allStock = stockRepository.findAll(pageable);

        return allStock.map(stockEntityToDtoMapper::mapEntitytoDto);
    }
}
