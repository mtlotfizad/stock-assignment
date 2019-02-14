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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.ok;

@Controller
public class StockJspController {

    private final StockCrudService stockCrudService;
    private final CreateStockViewModelMapper createStockViewModelMapper;

    public StockJspController(StockCrudService stockCrudService, CreateStockViewModelMapper createStockViewModelMapper) {
        this.stockCrudService = stockCrudService;
        this.createStockViewModelMapper = createStockViewModelMapper;
    }

    @RequestMapping(value="/list-stocks", method = RequestMethod.GET)
    public String showStocks(ModelMap model){
        model.put("stocks", stockCrudService.listAll(new PageRequest(0,10)));
        return "list-stocks";
    }



}
