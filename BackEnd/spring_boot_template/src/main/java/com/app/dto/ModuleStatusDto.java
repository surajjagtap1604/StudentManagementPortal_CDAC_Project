package com.app.dto;

public class ModuleStatusDto {

private String moduleName;

private String status;



public String getModuleName() {
	return moduleName;
}



public void setModuleName(String moduleName) {
	this.moduleName = moduleName;
}



public String getStatus() {
	return status;
}



public void setStatus(String status) {
	this.status = status;
}



public ModuleStatusDto(String moduleName, String status) {
	super();
	this.moduleName = moduleName;
	this.status = status;
}



public ModuleStatusDto() {
	super();
	// TODO Auto-generated constructor stub
}




}

