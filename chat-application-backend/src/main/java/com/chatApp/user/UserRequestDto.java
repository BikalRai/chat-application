package com.chatApp.user;

import java.time.LocalDate;

public class UserRequestDto {

	private String email;
	private String password;
	private String username;
	private String userImg;
	private Statuses status;
	private LocalDate createAt;
	private LocalDate lastSeen;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public Statuses getStatus() {
		return status;
	}

	public void setStatus(Statuses status) {
		this.status = status;
	}

	public LocalDate getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDate createAt) {
		this.createAt = createAt;
	}

	public LocalDate getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(LocalDate lastSeen) {
		this.lastSeen = lastSeen;
	}

}
