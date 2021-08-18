package com.infosys.coachms.controller;

import com.infosys.coachms.dto.CoachDTO;
import com.infosys.coachms.dto.LoginDTO;
import com.infosys.coachms.exception.WeCareException;
import com.infosys.coachms.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class CoachController {

    @Autowired
    private CoachService coachService;

    @PostMapping("/coaches")
    ResponseEntity<String> createCoach(@Valid @RequestBody CoachDTO coachDTO){
        return new ResponseEntity<>(coachService.createCoach(coachDTO),HttpStatus.OK);
    }

    @GetMapping("coaches/{coachId}")
    ResponseEntity<CoachDTO> getCoachProfile(@Valid @PathVariable String coachId){
        CoachDTO coach = coachService.getCoachById(coachId);
        return new ResponseEntity<>(coach, HttpStatus.FOUND);
    }

    @GetMapping("/coaches/all")
    List<CoachDTO> showAllCoaches() {
        return coachService.getAllCoaches();
    }
    @PostMapping("/coaches/login")
    public ResponseEntity<Boolean> loginCoach(@RequestBody LoginDTO login) throws WeCareException{
    	Boolean result = coachService.coachLogin(login);
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
}
