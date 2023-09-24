package com.app.dto;

public class FacultyTimeTableDto {

	
	private Long facultyId;
	
	private String courseName;
	
	public Long getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public FacultyTimeTableDto(Long facultyId, String courseName) {
		super();
		this.facultyId = facultyId;
		this.courseName = courseName;
	}
	public FacultyTimeTableDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
