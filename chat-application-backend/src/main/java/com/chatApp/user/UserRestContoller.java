package com.chatApp.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRestContoller {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<UserResponseDto> creteUser(@RequestBody UserRequestDto userReqDto) {
		
		User createdUser = userService.createUser(userReqDto);
		
		UserResponseDto res = new UserResponseDto(createdUser.getId(), createdUser.getEmail());
		
		
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}
	
}
