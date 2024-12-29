package com.chatApp.user;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(unique = true)
	private String username;
	private String password;
	private String userImg;
	private Roles role;
	private Statuses status;
	private LocalDate createAt;
	private LocalDate lastSeen;

	public User() {

	}

	public User(Integer id, String email, String username, String password, String userImg, Roles role, Statuses status,
			LocalDate createAt, LocalDate lastSeen) {

		Id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.userImg = userImg;
		this.role = role;
		this.status = status;
		this.createAt = createAt;
		this.lastSeen = lastSeen;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
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

	@Override
	public String toString() {
		return "User [Id=" + Id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", userImg=" + userImg + ", role=" + role + ", status=" + status + ", createAt=" + createAt
				+ ", lastSeen=" + lastSeen + "]";
	}

}
