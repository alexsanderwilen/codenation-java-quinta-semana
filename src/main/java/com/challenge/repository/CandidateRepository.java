package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository <Candidate, CandidateId> {

    //@Query(value = "SELECT candidate.status, candidate.user_id, candidate.company_id, candidate.acceleration_id, candidate.createdat from candidate where candidate.user_id = :companyId and candidate.company_id = :userId and candidate.acceleration_id = :accelerationId", nativeQuery = true)
    @Query("select c from Candidate c join c.id.user cu join c.id.company cc join c.id.acceleration ca where cu.id = :userId and cc.id = :companyId and ca.id = :accelerationId")
    Candidate findById(@Param("userId") Long userId, @Param("companyId") Long companyId, @Param("accelerationId") Long accelerationId);

    //@Query(value = "SELECT * from candidate where candidate.company_id = ?1", nativeQuery = true)
    @Query("select c from Candidate c join c.id.company cc where cc.id = :companyId")
    List<Candidate> findByCompanyId(@Param("companyId") Long companyId);

    //@Query(value = "SELECT * from candidate where candidate.acceleration_id = ?1", nativeQuery = true)
    @Query("select c from Candidate c join c.id.acceleration ca where ca.id = :accelerationId")
    List<Candidate> findByAccelerationId( @Param("accelerationId") Long accelerationId);
}
