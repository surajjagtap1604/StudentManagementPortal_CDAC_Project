package com.app.service;

import java.io.IOException;
import java.util.List;

import com.app.dto.AttendencePercentageDto;
import com.app.dto.CurrentStudentIdDto;
import com.app.dto.ModuleDto;
import com.app.dto.StudentDto;
import com.app.dto.StudentMarksArrayObjectDto;
import com.app.dto.SubjectCourseDto;
import com.app.dto.SubjectMarksDto;
import com.app.dto.TimeTableDto;

public interface StudentService {

	StudentDto getStudentDetails(CurrentStudentIdDto  currentStudentIdDto);

	List<String> getSubjectsList(CurrentStudentIdDto currentStudentIdDto);

	ModuleDto getModuleList(SubjectCourseDto subjectCourseDto);

	List<StudentMarksArrayObjectDto> getSubjectMarks(CurrentStudentIdDto currentStudentIdDto);
	
      
	float getStudentAttendence(CurrentStudentIdDto currentStudentIdDto);

	
	TimeTableDto getTimeTable(CurrentStudentIdDto currentStudentIdDto) throws IOException;
	
}
