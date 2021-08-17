package com.infosys.coachms.service;

import com.infosys.coachms.dto.CoachDTO;
import com.infosys.coachms.dto.LoginDTO;
import com.infosys.coachms.entity.Coach;
import com.infosys.coachms.exception.AllSignUpFieldException;
import com.infosys.coachms.repository.CoachRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.infosys.coachms.exception.AllSignUpFieldException;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class CoachServiceImpl implements CoachService{

    @Autowired
    private CoachRepository coachRepo;

    @Autowired
    private ModelMapper mapper;

    public CoachDTO getCoachById(String id) {
        Optional<Coach> coach = coachRepo.findById(id);
        if(coach.isPresent()) return mapper.map(coach.get(), CoachDTO.class);

        // Todo: Throw Exception
        else return null;
    }

    @Override
    public List<CoachDTO> getAllCoaches() {
        List<Coach> coaches = coachRepo.findAll();
        Type listType = new TypeToken<List<CoachDTO>>(){}.getType();
        return mapper.map(coaches,listType);

        //Todo: Throw Exception
    }

//    @Override
//    @Transactional
//    public String createCoach(CoachDTO coachDTO) {
//        coachRepo.saveAndFlush(mapper.map(coachDTO,Coach.class));
//        return "coach created";
//    }
    @Override
    public String createCoach(CoachDTO coachDTO){
        coachRepo.save(mapper.map(coachDTO,Coach.class));
        return "Your Profile is created Successfull and your Coach id is: "+coachDTO.getCoachId();
    }
    
    @Override
    public Boolean coachLogin(LoginDTO login) {
    	String id = login.getId();
    	String password = login.getPassword();
    	Optional<Coach> result = coachRepo.findById(id);
    	return result.isPresent();
    }
}
