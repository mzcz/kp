package com.kp.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BalanceDto {

    private Long id;
    private String name;
    private BigDecimal amount;
    private String approvers;
    private Category category;
    private String content;
    private LocalDate createDate;
    private String createBy;
}

