package com.app.dto;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.app.entity.Course;
import com.app.entity.Subject;
import com.app.entity.enums.Gender;

public class FacultyDto {

	
	private String name;
	
	private String phoneNo;
	
	private Gender gender;
	
	private int facultyExperience;
	
	private String email;
	
	

	

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

	public int getFacultyExperience() {
		return facultyExperience;
	}

	public void setFacultyExperience(int facultyExperience) {
		this.facultyExperience = facultyExperience;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public FacultyDto(String name, String phoneNo, Gender gender, int facultyExperience) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.facultyExperience = facultyExperience;
		
	}

	public FacultyDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
