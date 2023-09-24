package com.app.dto;

public class SubjectCourseDto {

	private String subjectName;

	private Long studentId;

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public SubjectCourseDto(String subjectName, Long studentId) {
		super();
		this.subjectName = subjectName;
		this.studentId = studentId;
	}

	public SubjectCourseDto() {
		super();
	}



	
	

}
