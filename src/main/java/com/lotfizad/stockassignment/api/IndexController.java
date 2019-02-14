package com.lotfizad.stockassignment.api;

import com.lotfizad.stockassignment.service.StockCrudService;
import com.lotfizad.stockassignment.service.dto.StockDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    private final StockCrudService stockCrudService;

    public IndexController(StockCrudService stockCrudService) {
        this.stockCrudService = stockCrudService;
    }

    @RequestMapping("/")
    public ModelAndView stockList() {
        Page<StockDto> page = stockCrudService.listAll(new PageRequest(0, 10));
        ModelAndView map = new ModelAndView("index");
        map.addObject("page", page);
        return map;
    }

}
