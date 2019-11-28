package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query(value = "SELECT * FROM company where company.id in (select candidate.company_id from candidate where candidate.acceleration_id = :accelerationId)", nativeQuery = true)
    List<Company> findByAccelerationId(@Param("accelerationId") Long accelerationId);

    @Query(value = "SELECT * FROM company where company.id in (select candidate.company_id from candidate where candidate.user_id = :userId)", nativeQuery = true)
    List<Company> findByUserId(@Param("userId") Long userId);
}
