package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    @Query(value = "select c.* from challenge c inner join submission s on (s.challenge_id = c.id ) inner join acceleration a on (a.challenge_id = c.id) where s.user_id = :userId and a.id = :accelerationId", nativeQuery = true)
    List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId, @Param("userId") Long userId);
}
