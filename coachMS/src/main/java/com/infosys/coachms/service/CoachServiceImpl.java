package com.infosys.coachms.service;

import com.infosys.coachms.dto.BookingDTO;
import com.infosys.coachms.dto.CoachDTO;
import com.infosys.coachms.dto.LoginDTO;
import com.infosys.coachms.entity.Coach;
import com.infosys.coachms.exception.ExceptionConstants;
import com.infosys.coachms.exception.WeCareException;
import com.infosys.coachms.repository.CoachRepository;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



import org.springframework.web.client.RestTemplate;




import java.lang.reflect.Type;

import java.util.*;

@Service
public class CoachServiceImpl implements CoachService{
	@Autowired
	private RestTemplate template;
    @Autowired
    private CoachRepository coachRepo;

    @Autowired
    private ModelMapper mapper;
    
    

    public CoachDTO getCoachById(String id) {
        Optional<Coach> coach = coachRepo.findById(id);
        if(coach.isPresent()) return mapper.map(coach.get(), CoachDTO.class);
        else throw new WeCareException(ExceptionConstants.COACH_NOT_FOUND.toString(), HttpStatus.BAD_REQUEST.value());
    }
   

    @Override
    public List<CoachDTO> getAllCoaches() {
        List<Coach> coaches = coachRepo.findAll();
        Type listType = new TypeToken<List<CoachDTO>>(){}.getType();
        if (!coaches.isEmpty()) return mapper.map(coaches,listType);
        else throw new WeCareException(ExceptionConstants.COACH_NOT_FOUND.toString(), HttpStatus.BAD_REQUEST.value());
    }

    @Override
    public String createCoach(CoachDTO coachDTO){
        coachRepo.save(mapper.map(coachDTO,Coach.class));
        return "Your Profile is created Successfully and your Coach id is: "+coachDTO.getCoachId();
    }
    
    @Override
    public Boolean loginCoach(LoginDTO login) throws WeCareException {
    	String id = login.getId();
    	String password = login.getPassword();
    	Optional<Coach> result = coachRepo.findById(id);
    	if(result.isEmpty()) {
    	    throw new WeCareException(ExceptionConstants.COACH_NOT_FOUND.toString(), HttpStatus.BAD_REQUEST.value());
    	}
    	else {
    		CoachDTO person = mapper.map(result.get(), CoachDTO.class);
    		if(person.getPassword().equals(password)) {
    			return true;
    		}
    		else throw new WeCareException(ExceptionConstants.COACH_NOT_FOUND.toString(), HttpStatus.BAD_REQUEST.value());
    	}
    }


	@Override
    @HystrixCommand(fallbackMethod = "fallbackGetBookingSchedules")
	public List<BookingDTO> getBookingSchedules(String coachId) {
        ResponseEntity<BookingDTO[]> responseEntity = template.getForEntity("http://BookingMS/coaches/booking/" + coachId, BookingDTO[].class);
        BookingDTO[] booking = responseEntity.getBody();
        return Arrays.asList(booking);
	}

    public List<BookingDTO> fallbackGetBookingSchedules(String coachId){
        return Collections.emptyList();
    }
}
