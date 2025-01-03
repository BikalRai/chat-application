package com.chatApp.friend;

import com.chatApp.user.User;

public class FriendResponseDto {

	private Integer id;
	private String email;

	public FriendResponseDto(User user) {

		this.id = user.getId();
		this.email = user.getEmail();
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

}
