package com.kp.spring.repository;

import com.kp.spring.domain.BalanceDtos;
import com.kp.spring.domain.BalanceReportDto;
import com.kp.spring.domain.CategoryDto;
import com.kp.spring.service.DbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BalanceDaoTest {

    @Autowired
    DbService service;


    @Test
    public void taskBalanceRepositoryTest() {

        //Given

        //When
        List<BalanceDtos> TaskBalanceDtos = service.getAvialableBalance();

        for (BalanceDtos taskDto : TaskBalanceDtos) {
            System.out.println(taskDto.getId() + " " + taskDto.getName() + " " + taskDto.getType());
        }
    }

    @Test
    public void taskBalanceRepositoryTest2() {

        //Given

        //When
        List<BalanceDtos> TaskBalanceDtos = service.getAvialableBalance2("Przychody", 1);

        for (BalanceDtos taskDto : TaskBalanceDtos) {
            System.out.println(taskDto.getId() + " " + taskDto.getName() + " " + taskDto.getCategory_id()
                   +  " " + taskDto.getType_name() + " " + taskDto.getType() + " " + taskDto.getAmount()
                   + " " + taskDto.getApprovers() + " " + taskDto.getContent() + " " + taskDto.getCreateDate()
                   +  " " +taskDto.getCreateBy());
        }
    }

    @Test
    public void sumBalanceRepositoryTest() {

        //Given
        //When
        // Then
        List<BalanceReportDto> balanceReportDtos = service.getActiveCash();

        for (BalanceReportDto balanceReportDto: balanceReportDtos) {

            System.out.println(balanceReportDto.getName()
                            + " " + balanceReportDto.getJan()
                            + " " + balanceReportDto.getFeb()
                            + " " + balanceReportDto.getMar()
                            + " " + balanceReportDto.getApr()
                            + " " + balanceReportDto.getMay()
                            + " " + balanceReportDto.getJun()
                            + " " + balanceReportDto.getJul()
                            + " " + balanceReportDto.getAug()
                            + " " + balanceReportDto.getSep()
                             + " " + balanceReportDto.getRazem()
            );
        }
    }

    @Test
    public void getCategoryTest() {

        //Given
        //When
        // Then
        List<CategoryDto> categoryReportIncome = service.getCategory("Przychody");

        for (CategoryDto categoryReportDto: categoryReportIncome) {

            System.out.println(categoryReportDto.getId()
                    + " " + categoryReportDto.getName()
                    + " " + categoryReportDto.getType()
            );
        }

        List<CategoryDto> categoryReportOutcome = service.getCategory("Rozchody");

        for (CategoryDto categoryReportDto: categoryReportOutcome) {

            System.out.println(categoryReportDto.getId()
                    + " " + categoryReportDto.getName()
                    + " " + categoryReportDto.getType()
            );
        }
    }

    @Test
    public void getBilansDetailsAmountTest() {

        //Given
        //When
        // Then 9842.17

        for (int i=0; i<12; i++) {
            List<BigDecimal> balance = service.getBilansDetailsAmount(i);

            for (BigDecimal balanceValues : balance) {

                System.out.println( "i = " + i + " " + balanceValues
                );
            }
        }

    }



}