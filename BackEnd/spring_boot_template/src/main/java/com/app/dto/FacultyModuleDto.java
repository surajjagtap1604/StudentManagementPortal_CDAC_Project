package com.app.dto;

import java.util.HashMap;

public class FacultyModuleDto {

	private HashMap<String,String> moduleStatus;

	public HashMap<String, String> getModuleStatus() {
		return moduleStatus;
	}

	public void setModuleStatus(HashMap<String, String> moduleStatus) {
		this.moduleStatus = moduleStatus;
	}

	public FacultyModuleDto(HashMap<String, String> moduleStatus) {
		super();
		this.moduleStatus = moduleStatus;
	}

	public FacultyModuleDto() {
		super();
	}


	
	
	
	
}
