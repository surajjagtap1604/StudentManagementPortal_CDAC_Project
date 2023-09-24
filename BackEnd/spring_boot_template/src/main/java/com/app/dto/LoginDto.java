package com.app.dto;

import com.app.entity.enums.Role;

public class LoginDto {
	
	private String email;
	private String password;
	private Role role;
	
	
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	public LoginDto(String email, String password, Role role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public LoginDto() {
		super();
	}
	
	
	
	
	
	
	
	

}
