package com.kp.spring.repository;

import com.kp.spring.domain.ApproverType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ApproverTypeDao extends CrudRepository<ApproverType, Long>{

}
