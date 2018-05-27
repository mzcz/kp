package com.kp.spring.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="category_seq")
    @SequenceGenerator(
            name="category_seq",
            sequenceName="category_sequence",
            allocationSize=20
    )
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Set<Balance> balance;

    @Column(name = "type")
    private String type;

    public Category(){};

    public Category(String name, String type, Set<Balance> balance) {
        this.name = name;
        this.balance = balance;
        this.type = type;
    }

    public Category(Long id, String name, String type, Set<Balance> balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Balance> getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }
}
