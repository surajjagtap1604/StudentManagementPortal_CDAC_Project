package com.app.dto;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

public class UploadTimeTableDto {

	private String date;
	private String courseName;
	private MultipartFile image;

	public LocalDate getDate() {
		return LocalDate.parse(date);
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	
}
