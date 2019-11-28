package com.challenge.repository;

import com.challenge.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    @Query(value = "select coalesce(max(SUBMISSION.SCORE), 0) from SUBMISSION where SUBMISSION.CHALLENGE_ID = :challengeId", nativeQuery = true)
    BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);

    @Query(value = "select SUBMISSION.* from SUBMISSION inner join ACCELERATION A on SUBMISSION.CHALLENGE_ID = A.CHALLENGE_ID and A.ID = :accelerationId where A.CHALLENGE_ID = :challengeId", nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);
}
