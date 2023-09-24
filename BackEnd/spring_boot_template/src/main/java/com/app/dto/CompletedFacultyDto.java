package com.app.dto;

import java.util.ArrayList;
import java.util.List;

public class CompletedFacultyDto {

	
	private String courseName;
	private String subjectName;
	
	private List<String> modulesList=new ArrayList<>();

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

	public List<String> getModulesList() {
		return modulesList;
	}

	public void setModulesList(List<String> modulesList) {
		this.modulesList = modulesList;
	}

	public CompletedFacultyDto() {
		super();
	
	}

	public CompletedFacultyDto(String courseName, String subjectName, List<String> modulesList) {
		super();
		this.courseName = courseName;
		this.subjectName = subjectName;
		this.modulesList = modulesList;
	}
	
    
	
	
}
