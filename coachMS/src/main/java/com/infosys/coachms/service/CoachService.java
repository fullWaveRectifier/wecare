package com.infosys.coachms.service;

import com.infosys.coachms.dto.CoachDTO;
import com.infosys.coachms.dto.LoginDTO;
import com.infosys.coachms.exception.WeCareException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CoachService {
    CoachDTO getCoachById(String coachId);

    List<CoachDTO> getAllCoaches();

    String createCoach(CoachDTO coachDTO);
    
    Boolean coachLogin(LoginDTO login) throws WeCareException;
}
