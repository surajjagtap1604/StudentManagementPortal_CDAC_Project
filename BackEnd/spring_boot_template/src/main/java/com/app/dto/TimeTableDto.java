package com.app.dto;

import java.time.LocalDate;

public class TimeTableDto {
	private LocalDate date;
    
	private byte[] image;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public TimeTableDto() {
		super();
	}

	public TimeTableDto(LocalDate date, byte[] image) {
		super();
		this.date = date;
		this.image = image;
	}

	
	
	
	
	

}
