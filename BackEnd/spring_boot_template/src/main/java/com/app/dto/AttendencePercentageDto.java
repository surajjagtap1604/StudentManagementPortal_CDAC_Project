package com.app.dto;

public class AttendencePercentageDto {

	private float totalAttendance;

	public float getTotalAttendance() {
		return totalAttendance;
	}

	public void setTotalAttendance(float totalAttendance) {
		this.totalAttendance = totalAttendance;
	}

	public AttendencePercentageDto(float totalAttendance) {
		super();
		this.totalAttendance = totalAttendance;
	}

	public AttendencePercentageDto() {
		super();
	}

}
