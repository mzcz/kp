package com.kp.spring.service;

import com.kp.spring.domain.Balance;
import com.kp.spring.domain.BalanceDtos;
import com.kp.spring.domain.BalanceReportDto;
import com.kp.spring.domain.Category;
import com.kp.spring.repository.BalanceDao;
import com.kp.spring.repository.BalanceRepository;
import com.kp.spring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {

    @Autowired
    private BalanceRepository balanceRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BalanceDao balanceDao;

    public List<Balance> getAllBalance(){
        return balanceRepository.findAll();
    }

    public Optional<Balance> getBalance(final Long id){
        return balanceRepository.findById(id);
    }

    public Balance save(final Balance balance){
        return balanceRepository.save(balance);
    }

    public void delete(final Balance balance){
        balanceRepository.delete(balance);
    }


    public List<BalanceDtos> getAvialableBalance(){
        return balanceDao.getAvialableBalance();
    }

    public List<BalanceReportDto> getBalanceReport(){
        return balanceDao.getBalanceReport();
    }

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategory(final Long id){
        return categoryRepository.findById(id);
    }

    public Category save(final Category category){
        return categoryRepository.save(category);
    }

    public void delete(final Category category){
        categoryRepository.delete(category);
    }


}
