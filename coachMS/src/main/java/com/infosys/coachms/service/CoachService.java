package com.infosys.coachms.service;

import com.infosys.coachms.dto.CoachDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CoachService {
    CoachDTO getCoachById(String coachId);

    List<CoachDTO> getAllCoaches();

    String createCoach(CoachDTO coachDTO);
}
