package com.lotfizad.stockassignment;

import com.lotfizad.stockassignment.service.StockCrudService;
import com.lotfizad.stockassignment.service.dto.CreateStockDto;
import com.lotfizad.stockassignment.service.dto.StockDto;
import com.lotfizad.stockassignment.service.exceptions.StockAlreadyExistsException;
import com.lotfizad.stockassignment.service.exceptions.StockNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmptyDatabaseTests {


    @Autowired
    private StockCrudService stockCrudService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void createNewStock() {
        CreateStockDto createStockDto = new CreateStockDto().setName("st1").setPrice(10.34);
        StockDto stockDto = stockCrudService.createStock(createStockDto);
        assertThat(stockDto).isNotNull();
    }

    @Test(expected = StockAlreadyExistsException.class)
    public void createNewStockWithDuplicateNames() {
        CreateStockDto createStockDto = new CreateStockDto().setName("st1").setPrice(10.34);
        StockDto stockDto = stockCrudService.createStock(createStockDto);
        assertThat(stockDto).isNotNull();

        assertThatThrownBy(() ->
                stockCrudService.createStock(createStockDto)
        ).isInstanceOf(StockAlreadyExistsException.class);
    }

    @Test()
    public void getUnavailableStock() {
        assertThatThrownBy(() ->
                stockCrudService.fetchOne(100L))
                .isInstanceOf(StockNotFoundException.class);
    }

    @Test
    public  void updateUnavailableStock(){
        assertThatThrownBy(() ->
                stockCrudService.updatePrice(100L, 1.1))
                .isInstanceOf(StockNotFoundException.class);

    }

}

