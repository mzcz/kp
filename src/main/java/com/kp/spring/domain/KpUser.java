package com.kp.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "KpUser.retrieveMarcin",
        query = "FROM KpUser where firstName='Marcin' "),
        @NamedQuery(name = "KpUser.retrieveId",
                query = "FROM KpUser where id > :ID ")
})
@NamedNativeQuery(name = "KpUser.retrieveSurname",
            query = "select * from kp_users kp where kp.last_name like '%be%'",
resultClass = KpUser.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "kp_users")
public class KpUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_seq")
    @SequenceGenerator(
            name="user_seq",
            sequenceName="user_sequence",
            allocationSize=20
    )
    @NotNull
    @Column(name = "ID", unique = true)
    private long id;
    @Column(name = "logini_Id")
    private String loginId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(targetEntity = Approver.class, mappedBy = "kpUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Approver> approvers = new ArrayList<>();

    public KpUser(String loginId, String firstName, String lastName) {
        this.loginId = loginId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
