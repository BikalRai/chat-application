package com.chatApp.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.chatApp.roles.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

	@ManyToMany
	@JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private List<Roles> role;

	@Enumerated(EnumType.STRING)
	private Statuses status;

	@CreationTimestamp
	private LocalDateTime createdAt;
	private LocalDateTime lastSeen;

	public User() {

	}

	public User(Integer id, String email, String username, String password, String userImg, List<Roles> role,
			Statuses status, LocalDateTime createdAt, LocalDateTime lastSeen) {
		Id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.userImg = userImg;
		this.role = role;
		this.status = status;
		this.createdAt = createdAt;
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

	public List<Roles> getRole() {
		return role;
	}

	public void setRole(List<Roles> role) {
		this.role = role;
	}

	public Statuses getStatus() {
		return status;
	}

	public void setStatus(Statuses status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(LocalDateTime lastSeen) {
		this.lastSeen = lastSeen;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", userImg=" + userImg + ", role=" + role + ", status=" + status + ", createAt=" + createdAt
				+ ", lastSeen=" + lastSeen + "]";
	}

}
