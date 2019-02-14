package com.lotfizad.stockassignment.api;

import com.lotfizad.stockassignment.service.StockCrudService;
import com.lotfizad.stockassignment.service.dto.StockDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    private final StockCrudService stockCrudService;

    public IndexController(StockCrudService stockCrudService) {
        this.stockCrudService = stockCrudService;
    }

    @RequestMapping("/")
    public String stockList(Model model,
                            @PageableDefault(size = 2, direction = Sort.Direction.ASC) Pageable page) {
        Page<StockDto> resultSet = stockCrudService.listAll(page);
        model.addAttribute("resultSet", resultSet);
        return "index";
    }

}
