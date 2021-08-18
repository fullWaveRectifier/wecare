package com.infosys.coachms.repository;

import com.infosys.coachms.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CoachRepository extends JpaRepository<Coach,String> {
    Optional<Coach> findById(String id);

}
