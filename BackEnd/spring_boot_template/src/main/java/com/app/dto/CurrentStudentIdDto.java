package com.app.dto;

public class CurrentStudentIdDto {
	
	private Long studentId;

	

	public CurrentStudentIdDto(Long studentId) {
		super();
		this.studentId = studentId;
	}



	public Long getStudentId() {
		return studentId;
	}



	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}



	public CurrentStudentIdDto() {
		super();
	}
	
	

}
