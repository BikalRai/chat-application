package com.chatApp.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Boolean existsByEmail(String email);
	
	User getByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.userId LIKE :userId")
	User findUserByUserId(@Param("userId") String userId);
}
