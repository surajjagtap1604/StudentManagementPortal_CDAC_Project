package com.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.app.entity.enums.Gender;

@SuppressWarnings("serial")
@Entity
public class Faculty implements Serializable {

	
//	@Id
//    @OneToOne 
//    @JoinColumn(name = "faculty_id") 
//    private Login loginId;

	@Id
	@Column(name = "faculty_id")
	private Long facultyId;

	@OneToOne
	@JoinColumn(name = "faculty_id") 
	@MapsId
	private Login loginId;
	private String name;
	
	private String phoneNo;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private int facultyExperience;
	
	 @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL,orphanRemoval = true)
	 private List<CourseSubjectFaculty> courseSubjectFaculty = new ArrayList<>();

	public Faculty(Login loginId, String name, String phoneNo, Gender gender, int facultyExperience) {
		super();
		this.loginId = loginId;
		this.name = name;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.facultyExperience = facultyExperience;
	}

	public Faculty() {
		super();
	}

	public Faculty(String name, String phoneNo, Gender gender, int facultyExperience) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.facultyExperience = facultyExperience;
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

	public int getFacultyExperience() {
		return facultyExperience;
	}

	public void setFacultyExperience(int facultyExperience) {
		this.facultyExperience = facultyExperience;
	}


	public Long getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}

	public List<CourseSubjectFaculty> getCourseSubjectFaculty() {
		return courseSubjectFaculty;
	}

	public void setCourseSubjectFaculty(List<CourseSubjectFaculty> courseSubjectFaculty) {
		this.courseSubjectFaculty = courseSubjectFaculty;
	}
	
	 
}
