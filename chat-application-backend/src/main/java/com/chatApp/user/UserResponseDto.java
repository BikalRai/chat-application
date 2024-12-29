package com.chatApp.user;

public class UserResponseDto {

	private Integer id;
	private String email;

	public UserResponseDto(Integer id, String email) {

		this.id = id;
		this.email = email;
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
