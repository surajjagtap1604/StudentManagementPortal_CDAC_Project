package com.app.dto;

import java.util.ArrayList;

public class SubjectMarksDto {

	ArrayList<StudentMarksArrayObjectDto> markList = new ArrayList<StudentMarksArrayObjectDto>();

	public ArrayList<StudentMarksArrayObjectDto> getMarkList() {
		return markList;
	}

	public void setMarkList(ArrayList<StudentMarksArrayObjectDto> markList) {
		this.markList = markList;
	}

	public SubjectMarksDto(ArrayList<StudentMarksArrayObjectDto> markList) {
		super();
		this.markList = markList;
	}

	public SubjectMarksDto() {
		super();
	}
	
	

}
