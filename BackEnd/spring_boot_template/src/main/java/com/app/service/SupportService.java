package com.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.AddLoginDto;
import com.app.dto.AddStudentDto;
import com.app.dto.AttendanceDto;
import com.app.dto.CourseNameDto;
import com.app.dto.CurrentSupportDto;
import com.app.dto.SupportDto;
import com.app.dto.UpdateAttendanceDto;
import com.app.dto.UploadTimeTableDto;

public interface SupportService {

	SupportDto getSupportDetails(CurrentSupportDto currentSupportDto);

	List<String> getCoursesList();

	AttendanceDto getStudentAndSubjectList(CourseNameDto courseNameDto);

	String updateAttandance(UpdateAttendanceDto updateAttandanceDto);

	String createStudent(AddStudentDto addStudentDto);

	String createLogin(AddLoginDto addLoginDto);

	//String uploadTimeTable(UploadTimeTableDto uploadTimeTableDto);

	//String uploadTimeTable(LocalDate date, MultipartFile image, String courseo);

	String uploadTimeTable(String date, MultipartFile image, String course);

}
