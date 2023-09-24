package com.app.dto;

import java.time.LocalDate;

import com.app.entity.enums.Gender;

public class StudentDto {


	private String name;

	private String phoneNo;

	private String email;

	private Gender gender;

	private LocalDate dob;

	private LocalDate admissionDate;

	private int yearOfPassing;

	private String courseName;
	
	

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public int getYearOfPassing() {
		return yearOfPassing;
	}

	public void setYearOfPassing(int yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}



	public StudentDto(String name, String phoneNo, String email, Gender gender, LocalDate dob, LocalDate admissionDate,
			int yearOfPassing, String courseName) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.admissionDate = admissionDate;
		this.yearOfPassing = yearOfPassing;
		this.courseName = courseName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public StudentDto() {
		super();
	}
	
	
	

}
