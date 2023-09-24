package com.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.app.entity.enums.Gender;

@SuppressWarnings("serial")
@Entity
public class Support implements Serializable{
	
//	@Id
//    @OneToOne
//    @JoinColumn(name = "support_id") 
//    private Login loginId;
	
	@Id
	@Column(name = "support_id")
	private Long supportId;

	@OneToOne
	@JoinColumn(name = "support_id") 
	@MapsId
	private Login loginId;
	
	private String name;
	
	private String phoneNo;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;

	public Support(Login loginId, String name, String phoneNo, Gender gender) {
		super();
		this.loginId = loginId;
		this.name = name;
		this.phoneNo = phoneNo;
		this.gender = gender;
	}

	public Support() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login getLoginId() {
		return loginId;
	}

	public void setLoginId(Login loginId) {
		this.loginId = loginId;
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
	
	

}











