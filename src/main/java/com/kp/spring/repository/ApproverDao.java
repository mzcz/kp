package com.kp.spring.repository;

import com.kp.spring.domain.Approver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ApproverDao extends CrudRepository<Approver, Long> {

    @Override
    List<Approver> findAll();
}
