package com.lotfizad.stockassignment;

import com.lotfizad.stockassignment.dto.CreateStockDto;
import com.lotfizad.stockassignment.exceptions.StockAlreadyExistsException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StockAssignmentApplicationTests {


    @Autowired
    private StockCrudService stockCrudService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void createNewStock() {
        CreateStockDto createStockDto = new CreateStockDto().setName("st1").setPrice(10.34);
        Long newStockId = stockCrudService.createStock(createStockDto);
        assertThat(newStockId).isNotNull();
    }

    @Test(expected = StockAlreadyExistsException.class)
    public void createNewStockWithDuplicateNames() {
        CreateStockDto createStockDto = new CreateStockDto().setName("st1").setPrice(10.34);
        Long newStockId = stockCrudService.createStock(createStockDto);
        assertThat(newStockId).isNotNull();

        assertThatThrownBy(() ->
                stockCrudService.createStock(createStockDto)
        ).isInstanceOf(StockAlreadyExistsException.class);
    }

}

