package com.app.service;

import java.io.IOException;
import java.util.List;

import com.app.dto.CompletedFacultyDto;
import com.app.dto.CourseSubjectDto;
import com.app.dto.CurrentFacultyDto;
import com.app.dto.FacultyCourseDto;
import com.app.dto.FacultyDto;
import com.app.dto.FacultyModuleDto;
import com.app.dto.FacultyTimeTableDto;
import com.app.dto.TimeTableDto;

public interface FacultyService {

	FacultyDto getFacultyDetails(CurrentFacultyDto currentFacultyDto);

	TimeTableDto getTimeTable(FacultyTimeTableDto facultyTimeTableDto) throws IOException;

	List<String> getCourseList(CurrentFacultyDto currentFacultyDto);

	List<String> getSubjectList(FacultyCourseDto facultyCourseDto);

	FacultyModuleDto getModuleList(CourseSubjectDto courseSubjectDto);

	String getCompletedModules(CompletedFacultyDto completedFacultyDto);

}
