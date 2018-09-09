package com.kp.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BalanceReportDto {

    @Id
    private String name;
    private BigDecimal jan;
    private BigDecimal feb;
    private BigDecimal mar;
    private BigDecimal apr;
    private BigDecimal may;
    private BigDecimal jun;
    private BigDecimal jul;
    private BigDecimal aug;
    private BigDecimal sep;
    private BigDecimal razem;
}
