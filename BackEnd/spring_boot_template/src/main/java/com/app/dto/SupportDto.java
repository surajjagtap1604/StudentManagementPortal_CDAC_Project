package com.app.dto;

import com.app.entity.enums.Gender;

public class SupportDto {
	
	
	private Long supportId;
	
	private String name;
	
	private String phoneNo;
	
	private Gender gender;
	

	public Long getSupportId() {
		return supportId;
	}

	public void setSupportId(Long supportId) {
		this.supportId = supportId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public SupportDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SupportDto(Long supportId, String name, String phoneNo, Gender gender) {
		super();
		this.supportId = supportId;
		this.name = name;
		this.phoneNo = phoneNo;
		this.gender = gender;
	}
	
	
	
}
