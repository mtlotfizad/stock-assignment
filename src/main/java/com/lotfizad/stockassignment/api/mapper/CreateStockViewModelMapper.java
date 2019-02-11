package com.lotfizad.stockassignment.api.mapper;

import com.lotfizad.stockassignment.api.viewModel.CreateStockViewModel;
import com.lotfizad.stockassignment.service.dto.CreateStockDto;
import org.springframework.stereotype.Component;

@Component
public class CreateStockViewModelMapper {
    public CreateStockDto fromViewModelToDto(CreateStockViewModel createStock) {
        return new CreateStockDto()
                .setName(createStock.getName())
                .setPrice(createStock.getPrice());
    }
}
