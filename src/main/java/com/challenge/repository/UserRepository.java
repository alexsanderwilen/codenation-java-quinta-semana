package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select users.* from users inner join candidate on (users.id = candidate.user_id) inner join acceleration on (acceleration.id = candidate.acceleration_id) where acceleration.name = :name", nativeQuery = true)
    List<User> findByAccelerationName(@Param("name") String name);

    @Query(value = "select users.* from users inner join candidate on (users.id = candidate.user_id) where candidate.company_id = :companyId", nativeQuery = true)
    List<User> findByCompanyId(@Param("companyId") Long companyId);
}
