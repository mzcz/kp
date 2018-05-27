package com.kp.spring.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "balance")
public class Balance {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="balance_seq")
    @SequenceGenerator(
            name="balance_seq",
            sequenceName="balance_sequence",
            allocationSize=20
    )
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "approvers")
    private String approvers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @Column(name = "description")
    private String content;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "create_by")
    private String createBy;

    public Balance(){};

    public Balance(String name, BigDecimal amount, String approvers, Category category, String content, LocalDate createDate, String createBy) {
        this.name = name;
        this.amount = amount;
        this.approvers = approvers;
        this.category = category;
        this.content = content;
        this.createDate = createDate;
        this.createBy = createBy;
    }

    public Balance(Long id, String name, BigDecimal amount, String approvers, Category category, String content, LocalDate createDate, String createBy) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.approvers = approvers;
        this.category = category;
        this.content = content;
        this.createDate = createDate;
        this.createBy = createBy;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getApprovers() {
        return approvers;
    }

    public Category getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public String getCreateBy() {
        return createBy;
    }
}

