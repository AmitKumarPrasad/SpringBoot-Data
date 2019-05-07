package com.amit.SpringData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.amit.SpringData.model.User;
@Component
public interface UserRepository extends JpaRepository<User, Long>{

	User findByName(String name);

	

}
