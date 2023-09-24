package com.app.dto;

public class FacultyCourseDto {

	
	private Long id;
	
	private String courseName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public FacultyCourseDto(Long id, String courseName) {
		super();
		this.id = id;
		this.courseName = courseName;
	}

	public FacultyCourseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
