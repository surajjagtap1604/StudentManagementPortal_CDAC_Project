package com.app.dto;

public class StudentMarksArrayObjectDto {
	
	private int marks;
	private String subjectName;
	public StudentMarksArrayObjectDto(int marks, String subjectName) {
		super();
		this.marks = marks;
		this.subjectName = subjectName;
	}
	public StudentMarksArrayObjectDto() {
		super();
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	
	
	
	
	
	
	
	

}
