package com.chatApp.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User createUser(UserRequestDto userReqDto) {
		
//		check if the user already exists
		if(userRepo.existsByEmail(userReqDto.getEmail())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists!!");
		}
		
		User user = new User();
		
		user.setEmail(userReqDto.getEmail());
		user.setPassword(userReqDto.getPassword());
		
		return userRepo.save(user);
	}

	public List<User>getAllUsers() {
		return userRepo.findAll();

	}

}
