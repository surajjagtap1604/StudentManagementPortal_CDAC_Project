package com.app.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AttendanceDto {

	
	HashMap<Long,String>  studentNameandId=new HashMap<>();
	
	List<String> subjectsNameList=new ArrayList<>();

	public HashMap<Long, String> getStudentNameandId() {
		return studentNameandId;
	}

	public void setStudentNameandId(HashMap<Long, String> studentNameandId) {
		this.studentNameandId = studentNameandId;
	}

	public List<String> getSubjectsNameList() {
		return subjectsNameList;
	}

	public void setSubjectsNameList(List<String> subjectsNameList) {
		this.subjectsNameList = subjectsNameList;
	}

	public AttendanceDto(HashMap<Long, String> studentNameandId, List<String> subjectsNameList) {
		super();
		this.studentNameandId = studentNameandId;
		this.subjectsNameList = subjectsNameList;
	}

	public AttendanceDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
