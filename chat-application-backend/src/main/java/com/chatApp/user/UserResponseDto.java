package com.chatApp.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class UserResponseDto {

	private Integer id;
	private String email;
	private LocalDateTime createdAt;
	private List<String> role;

	public UserResponseDto(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.createdAt = user.getCreatedAt();
		this.role = user.getRole().stream().map(role -> role.getRole()).collect(Collectors.toList());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<String> getRole() {
		return role;
	}

	public void setRole(List<String> role) {
		this.role = role;
	}

}
