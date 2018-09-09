package com.kp.spring.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "approver_types")
public class ApproverType {

    @Id
    @NotNull
    @Column(name="id", unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appr_type_seq")
    @SequenceGenerator(name="appr_type_seq", sequenceName = "APPR_TYPE_SEQUENCE", allocationSize = 20)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "createdDate", nullable = false)
    private LocalDate createdDate;

    public ApproverType(){

    }
    public ApproverType(String name){
        this.name = name;
        this.createdDate = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
