package com.infosys.userms.repository;

import com.infosys.userms.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, String> {


}
