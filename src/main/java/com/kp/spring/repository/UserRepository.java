package com.kp.spring.repository;

import com.kp.spring.domain.KpUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<KpUser, Long> {

    @Override
    List<KpUser> findAll();

    @Override
    KpUser save(KpUser kpUser);

    @Override
    Optional<KpUser> findById(Long id);

    Optional<KpUser> findByLoginId(String loginId);

    @Override
    void deleteById(Long id);

    @Query
    List<KpUser> retrieveMarcin();

    @Query
    List<KpUser> retrieveId(@Param("ID") long id);

    @Query(nativeQuery = true)
    List<KpUser> retrieveSurname();

}
