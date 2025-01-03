package com.chatApp.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.chatApp.friend.FriendResponseDto;

public class UserResponseDto {

	private Integer id;
	private String email;
	private String userId;
	private LocalDateTime createdAt;
	private List<String> role;
	private List<FriendResponseDto> friendsList;

	public UserResponseDto(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.userId = user.getUserId();
		this.createdAt = user.getCreatedAt();
		this.role = user.getRole().stream().map(role -> role.getRole()).collect(Collectors.toList());
		this.friendsList = user.getFriends() == null ? List.of()
				: user.getFriends().stream().map(friend -> new FriendResponseDto(friend.getUser()))
						.collect(Collectors.toList());
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

	public List<FriendResponseDto> getFriendsList() {
		return friendsList;
	}

	public void setFriendsList(List<FriendResponseDto> friendsList) {
		this.friendsList = friendsList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
