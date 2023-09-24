package com.app.dto;

import java.util.HashMap;

public class ModuleDto {

	private HashMap<String,String> moduleStatus;
	
	private String facultyName;

	public HashMap<String, String> getModuleStatus() {
		return moduleStatus;
	}

	public void setModuleStatus(HashMap<String, String> moduleStatus) {
		this.moduleStatus = moduleStatus;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public ModuleDto(HashMap<String, String> moduleStatus, String facultyName) {
		super();
		this.moduleStatus = moduleStatus;
		this.facultyName = facultyName;
	}

	public ModuleDto() {
		super();
	}

	


	

}
