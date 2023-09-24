package com.app.dto;

import java.util.HashMap;

public class UpdateAttendanceDto {
	
	private String courseName;
	
	private HashMap<Long,HashMap<String,String>> StudentAttendance;
	
	
	
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public HashMap<Long, HashMap<String, String>> getStudentAttendance() {
		return StudentAttendance;
	}
	public void setStudentAttendance(HashMap<Long, HashMap<String, String>> studentAttendance) {
		StudentAttendance = studentAttendance;
	}
	public UpdateAttendanceDto(String courseName, HashMap<Long, HashMap<String, String>> studentAttendance) {
		super();
		this.courseName = courseName;
		StudentAttendance = studentAttendance;
	}
	public UpdateAttendanceDto() {
		super();
	}
}
