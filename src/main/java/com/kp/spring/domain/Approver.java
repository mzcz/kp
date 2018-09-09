package com.kp.spring.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "Approvers")
public class Approver {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appr_seq")
    @SequenceGenerator(name = "appr_seq", sequenceName = "APPR_SEQUENCE", allocationSize = 20)
    @NotNull
    @Column(name = "id", unique = true)
    private long id;
    @ManyToOne
    @JoinColumn(name = "login_Id")
    private KpUser kpUser;
    @Column(name = "description")
    private String description;
    @Column(name = "created_date" ,nullable = false)
    private LocalDate createdDate;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="TYPE_ID")
    private ApproverType approverType;

    public Approver(){
    }

    public Approver(String description) {
        this.description = description;
        this.createdDate = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public KpUser getLogin() {
        return kpUser;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public ApproverType getApproverType() {
        return approverType;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLogin(KpUser kpUser) {
        this.kpUser = kpUser;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public void setApproverType(ApproverType approverType) {
        this.approverType = approverType;
    }
}
