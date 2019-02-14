package com.lotfizad.stockassignment;


import com.lotfizad.stockassignment.repository.StockRepository;
import com.lotfizad.stockassignment.repository.domain.StockEntity;
import com.lotfizad.stockassignment.service.StockCrudService;
import com.lotfizad.stockassignment.service.dto.StockDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilledDatabaseTest {
    @Autowired
    private StockCrudService stockCrudService;

    @Autowired
    private StockRepository stockRepository;

    @Before
    public void addSomeStock() {
        stockRepository.save(new StockEntity("test1", 10.01));
        stockRepository.save(new StockEntity("test2", 11.01));
        stockRepository.save(new StockEntity("test3", 12.01));
        stockRepository.save(new StockEntity("test4", 13.01));
    }

    @Test
    public void getStockListTest() {
        Page<StockDto> listAll = stockCrudService.listAll(new PageRequest(0, 20));
        assertThat(listAll).isNotEmpty();
    }

    @Test()
    public void getAvailableStock() {
        StockDto stockDto = stockCrudService.fetchOne(1L);
        assertThat(stockDto.getName()).isEqualTo("test1");
    }

    @Test
    public void updateUnavailableStock() {
        double newPrice = 1.1;
        stockCrudService.updatePrice(1L, newPrice);
        assertThat(stockRepository.findOne(1L).getCurrentPrice()).isEqualTo(newPrice);

    }
}
