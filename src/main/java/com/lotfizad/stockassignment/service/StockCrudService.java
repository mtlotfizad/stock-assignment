package com.lotfizad.stockassignment.service;

import com.lotfizad.stockassignment.repository.StockRepository;
import com.lotfizad.stockassignment.repository.domain.StockEntity;
import com.lotfizad.stockassignment.service.dto.CreateStockDto;
import com.lotfizad.stockassignment.service.dto.StockDto;
import com.lotfizad.stockassignment.service.exceptions.StockAlreadyExistsException;
import com.lotfizad.stockassignment.service.exceptions.StockNotFoundException;
import com.lotfizad.stockassignment.service.mapper.StockEntityToDtoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockCrudService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final StockRepository stockRepository;
    private final StockEntityToDtoMapper stockEntityToDtoMapper;

    public StockCrudService(StockRepository stockRepository, StockEntityToDtoMapper stockEntityToDtoMapper) {
        this.stockRepository = stockRepository;
        this.stockEntityToDtoMapper = stockEntityToDtoMapper;
    }

    public StockDto createStock(CreateStockDto createStockDto) {
        log.info("Creating new Stock: {}", createStockDto);
        String stockName = createStockDto.getName();
        StockEntity existedStock = stockRepository.findByName(stockName);
        if (existedStock != null) {
            throw new StockAlreadyExistsException(
                    String.format("Stock with stock name %s is already defined.", createStockDto.getName()));
        }

        StockEntity stockEntity = stockRepository.save(new StockEntity(stockName, createStockDto.getPrice()));
        return stockEntityToDtoMapper.mapEntitytoDto(stockEntity);
    }

    public Page<StockDto> listAll(Pageable pageable) {
        log.info("Retrieving list of Stocks ,page number: {}", pageable.getPageNumber());
        Page<StockEntity> allStock = stockRepository.findAll(pageable);

        return allStock.map(stockEntityToDtoMapper::mapEntitytoDto);
    }

    public StockDto fetchOne(Long stockId) {
        log.info("Fetching data for stock with id {}", stockId);
        StockEntity oneStock = findOne(stockId);

        return stockEntityToDtoMapper.mapEntitytoDto(oneStock);
    }

    public void updatePrice(Long stockId, Double newPrice) {
        log.info("Updating Stock#{}, new price={}", stockId, newPrice);
        StockEntity oneStock = findOne(stockId);
        oneStock.setCurrentPrice(newPrice);
        stockRepository.save(oneStock);
    }

    private StockEntity findOne(Long stockId) {
        Optional<StockEntity> foundOne = Optional.ofNullable(stockRepository.findOne(stockId));

        return foundOne.orElseThrow(
                () -> new StockNotFoundException(
                        String.format("Stock with ID %d not found.", stockId)));
    }
}
