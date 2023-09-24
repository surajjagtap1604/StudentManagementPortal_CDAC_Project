package com.app.dto;

public class CourseSubjectDto {

	
private String courseName;
	
	private String subjectName;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public CourseSubjectDto(String courseName, String subjectName) {
		super();
		this.courseName = courseName;
		this.subjectName = subjectName;
	}

	public CourseSubjectDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
