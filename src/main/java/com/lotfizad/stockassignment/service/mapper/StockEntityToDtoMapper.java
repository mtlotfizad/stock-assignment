package com.lotfizad.stockassignment.service.mapper;

import com.lotfizad.stockassignment.repository.domain.StockEntity;
import com.lotfizad.stockassignment.service.dto.StockDto;
import org.springframework.stereotype.Component;

@Component
public class StockEntityToDtoMapper {

    public StockDto mapEntitytoDto(StockEntity stockEntity) {
        return new StockDto()
                .setId(stockEntity.getId())
                .setName(stockEntity.getName())
                .setCurrentPrice(stockEntity.getCurrentPrice())
                .setLastUpdate(stockEntity.getLastUpdate());
    }
}
