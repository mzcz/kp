package com.kp.spring.repository;

import com.kp.spring.domain.Balance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BalanceRepository extends  CrudRepository<Balance, Long> {

    @Override
    List<Balance> findAll();

    @Override
    Optional<Balance> findById(Long id);

    @Override
    Balance save(Balance task);

    @Override
    void delete(Balance task);

    @Override
    long count();

}
