package com.chatApp.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.chatApp.roles.Roles;
import com.chatApp.roles.RolesRepository;
import com.chatApp.utilities.HashIdGenerator;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RolesRepository rolesRepo;
	
	@Autowired
	private HashIdGenerator hashIdGenerator;

	// create a new user
	public User createUser(UserRequestDto userReqDto) {

//		check if the user already exists
		if (userRepo.existsByEmail(userReqDto.getEmail())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists!!");
		}

		// create new user
		User user = new User();

		// add the all the new user details
		user.setEmail(userReqDto.getEmail());
		user.setUserId(hashIdGenerator.generatedHashId(user.getEmail()));
		user.setPassword(userReqDto.getPassword());
		user.setStatus(Statuses.ONLINE);

		Roles role = rolesRepo.findById(2)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Roles not found"));

		List<Roles> newUserRole = new ArrayList<>();
		newUserRole.add(role);

		user.setRole(newUserRole);

		return userRepo.save(user);
	}

//	get all of the users in the system
	public List<User> getAllUsers() {
		return userRepo.findAll();

	}

//	get user based on id
	public User getUserById(int id) {

		// return user based on id, else throw the error status and message
		return userRepo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
	}

//	update user
	public UserResponseDto updateUser(int id, UserRequestDto userReqDto) {

		// check if user exists
		Optional<User> existingUser = userRepo.findById(id);
		if (!existingUser.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existing user!!");
		}

		// create user object to transfer from optional object
		User updateUser = existingUser.get();

		// update user details if found
		updateUser.setEmail(userReqDto.getEmail());
		updateUser.setPassword(userReqDto.getPassword());
		updateUser.setUsername(userReqDto.getUsername());
		updateUser.setUserImg(userReqDto.getUserImg());
		userRepo.save(updateUser);

		// transfer to DTO
		UserResponseDto res = new UserResponseDto(updateUser);

		return res;
	}
	
	// search for users based on userId and not Id
	public User searchUserByUserId(String userId) {
		
		return userRepo.findUserByUserId(userId);
	}

//	 delete user
	public String deleteUser(int id) {

		// check if user exists
		Optional<User> existingUser = userRepo.findById(id);
		if (!existingUser.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		}

		// delete user if exists
		userRepo.deleteById(id);
		return "User deleted successfully";
	}
}
