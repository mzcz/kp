package com.kp.spring.service;

import com.kp.spring.domain.*;
import com.kp.spring.repository.BalanceDao;
import com.kp.spring.repository.BalanceRepository;
import com.kp.spring.repository.CategoryRepository;
import com.kp.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    @Autowired
    private UserRepository userRepository;


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

    public List<BalanceDtos> getAvialableBalance2(String bilansType, int month){
        return balanceDao.getAvialableBalance2(bilansType, month);
    }

    public BigDecimal getBilansAmount(String bilansType, int month) {
        return balanceDao.getBilansAmount(bilansType, month);
    }

    public List<BalanceReportDto> getBalanceReport(){
        return balanceDao.getBalanceReport();
    }

    public List<BalanceReportDto> getActiveCash(){
        return balanceDao.getActiveCash();
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


    public List<KpUser> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<KpUser> getUser(long id){
        return userRepository.findById(id);
    }

    public Optional<KpUser> getUser(String loginId){
        return userRepository.findByLoginId(loginId);
    }

    public KpUser saveKpUser(final KpUser kpUser){
        return userRepository.save(kpUser);
    }

    public void deleteUser(long id){
        userRepository.deleteById(id);
    }


    public List<CategoryDto> getCategory(String type){
        return balanceDao.getCategory(type);
    }

    public List<BigDecimal>  getBilansDetailsAmount(int month){
        return balanceDao.getBilansDetailsAmount(month);
    }

}
