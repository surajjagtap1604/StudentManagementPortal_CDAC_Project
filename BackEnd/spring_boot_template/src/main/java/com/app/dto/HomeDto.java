package com.app.dto;

public class HomeDto {
	
	private String message;
	
	private String username;
	
	private Long login_id;
	
	private String role;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getLogin_id() {
		return login_id;
	}

	public void setLogin_id(Long login_id) {
		this.login_id = login_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public HomeDto(String message, String username, Long login_id, String role) {
		super();
		this.message = message;
		this.username = username;
		this.login_id = login_id;
		this.role = role;
	}

	public HomeDto(String message) {
		super();
		this.message = message;
	}

	public HomeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}