package com.infosys.userms.service;

import com.infosys.userms.dto.UserDTO;
import com.infosys.userms.entity.UserEntity;
import com.infosys.userms.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public UserDTO getUserById(String id) {
        Optional<UserEntity> user = userRepo.findById(id);
        System.out.println(user.isPresent());
        if(user.isPresent()) return mapper.map(user.get(), UserDTO.class);

        //  Todo: Throw Exceptions

        else return null;
    }

}
