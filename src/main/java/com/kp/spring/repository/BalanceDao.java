package com.kp.spring.repository;

import com.kp.spring.domain.BalanceDtos;
import com.kp.spring.domain.BalanceReportDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BalanceDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public List<BalanceDtos> getAvialableBalance(){

        String SearchQuery = " select b.id, b.name, b.CATEGORY_ID, c.name as type_name, " +
                "c.type, b.amount, b.APPROVERS, b.DESCRIPTION as content , b.CREATE_DATE, b.CREATE_BY from balance b\n" +
                "        join category c on b.CATEGORY_ID = c.ID" +
                " order by b.id desc";

        return em.createNativeQuery(SearchQuery,BalanceDtos.class).getResultList();
    };

    @SuppressWarnings("unchecked")
    public List<BalanceReportDto> getBalanceReport(){

        String SearchQuery = " select name, jan, feb, mar, apr, may, razem from balance_total_vw ";

        return em.createNativeQuery(SearchQuery,BalanceReportDto.class).getResultList();
    };
}
