package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccelerationRepository extends JpaRepository<Acceleration, Long> {

    @Query(value = "SELECT acceleration.* FROM   acceleration INNER JOIN candidate ON ( acceleration.id = candidate.acceleration_id ) WHERE  candidate.company_id = :companyId", nativeQuery = true)
    List<Acceleration> findByCompanyId(@Param("companyId") Long companyId);
}
