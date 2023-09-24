package com.app.service;

import static org.apache.commons.io.FileUtils.readFileToByteArray;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.CompletedFacultyDto;
import com.app.dto.CourseSubjectDto;
import com.app.dto.CurrentFacultyDto;
import com.app.dto.FacultyCourseDto;
import com.app.dto.FacultyDto;
import com.app.dto.FacultyModuleDto;
import com.app.dto.FacultyTimeTableDto;
import com.app.dto.TimeTableDto;
import com.app.entity.Course;
import com.app.entity.DisplayTimetable;
import com.app.entity.Faculty;
import com.app.entity.Login;
import com.app.entity.ModuleSubject;
import com.app.entity.Subject;
import com.app.repository.CourseRepo;
import com.app.repository.CourseSubjectFacultyRepo;
import com.app.repository.DisplayTimetableRepo;
import com.app.repository.FacultyRepo;
import com.app.repository.LoginRepo;
import com.app.repository.ModuleSubjectRepo;
import com.app.repository.SubjectRepo;

@Service
@Transactional
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	private FacultyRepo facultyRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private LoginRepo loginRepo;
	@Autowired
	private CourseSubjectFacultyRepo courseSubjectFacultyRepo;
	@Autowired
	private CourseRepo courseRepo;
	@Autowired
	private SubjectRepo subjectRepo;
	@Autowired
	private DisplayTimetableRepo displayTimetableRepo;
	@Autowired
	private ModuleSubjectRepo moduleSubjectRepo;

	@Override
	public FacultyDto getFacultyDetails(CurrentFacultyDto currentFacultyDto) {

		Faculty faculty = facultyRepo.findById(currentFacultyDto.getId())
				.orElseThrow(() -> new RuntimeException("Invalid Faculty Id"));



		Login facultyLoginDetails = loginRepo.findById(faculty.getFacultyId())
				.orElseThrow(() -> new RuntimeException("Invalid LoginId"));

		

		FacultyDto facultyDto=new FacultyDto(faculty.getName(),faculty.getPhoneNo(),faculty.getGender(),faculty.getFacultyExperience());
		facultyDto.setEmail(facultyLoginDetails.getEmail());
		
	

		return facultyDto;
	}

	@Override
	public TimeTableDto getTimeTable(FacultyTimeTableDto facultyTimeTableDto) throws IOException {

		TimeTableDto timeTableDto = new TimeTableDto();

		Long courseId = courseRepo.findCourseIdByCourseName(facultyTimeTableDto.getCourseName())
				.orElseThrow(() -> new RuntimeException("Invalid CourseName"));

		DisplayTimetable timetable = displayTimetableRepo.findTimeTableByCourseAndDate(courseId);

		if (timetable == null) {
			
			return null;
		}

		timeTableDto.setDate(timetable.getDate());

		String path = timetable.getImagePath();
		timeTableDto.setImage(readFileToByteArray(new File(path)));

		return timeTableDto;

	}

	@Override
	public List<String> getCourseList(CurrentFacultyDto currentFacultyDto) {

		List<Long> courseIdList = courseSubjectFacultyRepo.findCourseListByFacultyId(currentFacultyDto.getId())
				.orElseThrow(() -> new RuntimeException("Invalid Faculty Id"));

		List<String> courseNameList = new ArrayList<>();

		for (Long courseId : courseIdList) {
			Course course = courseRepo.findById(courseId).orElseThrow(() -> new RuntimeException("Invalid Course Id"));
			courseNameList.add(course.getName());

		}

		return courseNameList;
	}

	@Override
	public List<String> getSubjectList(FacultyCourseDto facultyCourseDto) {

		Long courseId = courseRepo.findCourseIdByCourseName(facultyCourseDto.getCourseName())
				.orElseThrow(() -> new RuntimeException("Invalid CourseName")); 
		
		List<Long> subjectIdList = courseSubjectFacultyRepo.findSubjectListByFacultyId(facultyCourseDto.getId(),courseId)
				.orElseThrow(() -> new RuntimeException("Invalid Faculty Id"));
		List<String> subjectList = new ArrayList<>();

		for (Long subjectId : subjectIdList) {
			
			Subject subject = subjectRepo.findById(subjectId)
					.orElseThrow(() -> new RuntimeException("Invalid Course Id"));
			subjectList.add(subject.getName());

		}
		return subjectList;
	}

	@Override
	public FacultyModuleDto getModuleList(CourseSubjectDto courseSubjectDto) {

		HashMap<String, String> map = new HashMap<>();

		Long courseId = courseRepo.findCourseIdByCourseName(courseSubjectDto.getCourseName())
				.orElseThrow(() -> new RuntimeException("Invalid CourseName"));
		Long subjectId = subjectRepo.findSubjectIdBySubjectName(courseSubjectDto.getSubjectName())
				.orElseThrow(() -> new RuntimeException("Invalid SubjectName"));

		List<String> moduleNameList = moduleSubjectRepo.findByCouseIdAndSubjectId(courseId, subjectId);
		List<String> moduleStatusList = moduleSubjectRepo.findStatusByCouseIdAndSubjectId(courseId, subjectId);

		for (int i = 0; i < moduleNameList.size(); i++) {

			map.put(moduleNameList.get(i), moduleStatusList.get(i));

		}

		
		return new FacultyModuleDto(map);
	}

	@Override
	public String getCompletedModules(CompletedFacultyDto completedFacultyDto) {
		try {
		Long courseId = courseRepo.findCourseIdByCourseName(completedFacultyDto.getCourseName())
				.orElseThrow(() -> new RuntimeException("Invalid CourseName"));
		
		Long subjectId=subjectRepo.findSubjectIdBySubjectName(completedFacultyDto.getSubjectName())
				.orElseThrow(() -> new RuntimeException("Invalid SubjectName"));
		
		List<String> totalList=completedFacultyDto.getModulesList();
		
		List<String> completedModules=new ArrayList<>();
		for(String completedlist: totalList)
		{
			if(completedlist!="false")
			{
			completedModules.add(completedlist);	
//		List<String> completedModules=completedFacultyDto.getModulesList();
			}
		}
		for(String completedModule: completedModules)
		{
//			ModuleSubject moduleSubject = new ModuleSubject(completedModule,courseId,subjectId);
			System.out.println(completedModule);
			System.out.println(courseId);
			System.out.println(subjectId);
			
			moduleSubjectRepo.updateModuleStatus(completedModule,courseId,subjectId);
			
		}
		
		
		
		
		return "Successful";
		}
		catch(Exception e)
		{
		return "Unsuccessful";
	}
	}

}
