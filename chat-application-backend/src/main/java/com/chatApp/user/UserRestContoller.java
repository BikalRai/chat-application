package com.chatApp.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userReqDto) {

		User createdUser = userService.createUser(userReqDto);

		UserResponseDto res = new UserResponseDto(createdUser);

		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") int id) {
		User user = userService.getUserById(id);

		UserResponseDto res = new UserResponseDto(user);
		return new ResponseEntity<>(res, HttpStatus.FOUND);
	}
	
	// end point to search for users based on userId
	@GetMapping("/users/search")
	public ResponseEntity<User> searchUser(@RequestParam("searchParam") String param) {
		
		return ResponseEntity.ok(userService.searchUserByUserId(param));
	}

	@PutMapping("/users/{id}/update")
	public ResponseEntity<UserResponseDto> updateUser(@PathVariable("id") int id,
			@RequestBody UserRequestDto userReqDto) {

		return new ResponseEntity<>(userService.updateUser(id, userReqDto), HttpStatus.OK);
	}

	@DeleteMapping("/users/delete/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable("id") int id) {
		return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
	}
}
