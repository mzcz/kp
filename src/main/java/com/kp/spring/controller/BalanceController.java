package com.kp.spring.controller;

import com.kp.spring.Mapper.BalanceMapper;
import com.kp.spring.Mapper.CategoryMapper;
import com.kp.spring.domain.BalanceDto;
import com.kp.spring.domain.BalanceDtos;
import com.kp.spring.domain.BalanceReportDto;
import com.kp.spring.domain.CategoryDto;
import com.kp.spring.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class BalanceController {

    @Autowired
    private DbService service;
    @Autowired
    private BalanceMapper balanceMapper;
    @Autowired
    private CategoryMapper categoryMapper;


    @RequestMapping(method = RequestMethod.GET, value = "/balance")
    public List<BalanceDto> getAllBalance() {
        return balanceMapper.mapToBalanceDtoList(service.getAllBalance());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/balanceAll")
    public List<BalanceDtos> getAvialableBalance() {
        return service.getAvialableBalance();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/balanceReport")
    public List<BalanceReportDto> getBalanceReport() {
        return service.getBalanceReport();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/balance/{balanceId}")
    public BalanceDto getBalance(@PathVariable Long balanceId) throws TaskNotFoundException {
        return balanceMapper.mapToBalanceDto(service.getBalance(balanceId).orElseThrow(TaskNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/balance/{balanceId}")
    public void deleteBalance(@PathVariable Long balanceId) throws TaskNotFoundException {
        service.delete(service.getBalance(balanceId).orElseThrow(TaskNotFoundException::new));
    };

    @RequestMapping(method = RequestMethod.PUT, value = "/updateBalance")
    public void updateBalance(@RequestBody BalanceDto balanceDto) {
             balanceMapper
                .mapToBalanceDto(service
                        .save(balanceMapper.mapToBalance(balanceDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createBalance", consumes = APPLICATION_JSON_VALUE)
    public BalanceDto createBalance (@RequestBody BalanceDto readerDto){
        return balanceMapper
                .mapToBalanceDto(service
                        .save(balanceMapper.mapToBalance(readerDto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category")
    public List<CategoryDto> getAllCategory() {
        return categoryMapper.mapToCategoryDtoList(service.getAllCategory());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createCategory", consumes = APPLICATION_JSON_VALUE)
    public CategoryDto createCategory (@RequestBody CategoryDto categoryDto){
        return categoryMapper
                .mapToCategoryDto(service
                        .save(categoryMapper.mapToCategory(categoryDto)));
    }

}
