package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.app.entity.Login;
import com.app.entity.enums.Gender;
import com.app.entity.enums.Role;

public class AddStudentDto {

    private String name;

    private String phoneNo;

    private String gender;

    private LocalDate dob;

    private LocalDate admissionDate;
    
    private int yearOfPassing;

    private String courseName;
    
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public AddStudentDto() {
		super();
		
	}

	public AddStudentDto(String name, String phoneNo, String gender, LocalDate dob, LocalDate admissionDate,
			int yearOfPassing, String courseName, String email) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.dob = dob;
		this.admissionDate = admissionDate;
		this.yearOfPassing = yearOfPassing;
		this.courseName = courseName;
		this.email = email;
	}

	


	

	
    
    
}
