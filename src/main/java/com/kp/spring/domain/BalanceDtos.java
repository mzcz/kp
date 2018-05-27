package com.kp.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BalanceDtos {

    @Id
    private Long id;
    private String name;
    private Long category_id;
    private String type_name;
    private String type;
    private BigDecimal amount;
    private String approvers;
    private String content;
    private LocalDate createDate;
    private String createBy;
}
