package com.app.dto;

public class ApiResponse {

	private String messege;

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

	public ApiResponse(String messege) {
		super();
		this.messege = messege;
	}

	public ApiResponse() {
		super();
	}

}
