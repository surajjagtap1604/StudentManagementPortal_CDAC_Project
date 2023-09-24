package com.app.service;

import static org.apache.commons.io.FileUtils.readFileToByteArray;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.AttendencePercentageDto;
import com.app.dto.CurrentStudentIdDto;
import com.app.dto.ModuleDto;
import com.app.dto.StudentDto;
import com.app.dto.StudentMarksArrayObjectDto;
import com.app.dto.SubjectCourseDto;
import com.app.dto.SubjectMarksDto;
import com.app.dto.TimeTableDto;
import com.app.entity.Course;
import com.app.entity.DisplayTimetable;
import com.app.entity.Faculty;
import com.app.entity.Login;
import com.app.entity.Student;
import com.app.entity.Subject;
import com.app.repository.CourseSubjectFacultyRepo;
import com.app.repository.DisplayTimetableRepo;
import com.app.repository.FacultyRepo;
import com.app.repository.LoginRepo;
import com.app.repository.ModuleSubjectRepo;
import com.app.repository.StudentAttendanceRepo;
import com.app.repository.StudentMarksRepo;
import com.app.repository.StudentRepo;
import com.app.repository.SubjectCourseRepo;
import com.app.repository.SubjectRepo;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentrepo;
	@Autowired
	private ModelMapper mapper;
//	@Autowired
//	private CourseRepo courseRepo;
	@Autowired
	private LoginRepo loginRepo;
	@Autowired
	private SubjectCourseRepo subjectCourseRepo;
	@Autowired
	private SubjectRepo subjectRepo;
	@Autowired
	private ModuleSubjectRepo moduleSubjectRepo;
	@Autowired
	private CourseSubjectFacultyRepo courseSubjectFacultyRepo;
	@Autowired
	private FacultyRepo facultyRepo;

	@Autowired
	private StudentMarksRepo studentMarksRepo;

	@Autowired
	private StudentAttendanceRepo studentAttendanceRepo;

	@Autowired
	private DisplayTimetableRepo displayTimetableRepo;

	@Value("${file.upload.location}")
	private String uploadFolder;

	@PostConstruct
	public void init() throws IOException {
		// chk if folder exists --yes --continue
		File folder = new File(uploadFolder);
		if (folder.exists()) {
			System.out.println("folder exists alrdy !");
		} else {
			// no --create a folder
			folder.mkdir();
			System.out.println("created a folder !");
		}
	}

	@Override
	public StudentDto getStudentDetails(CurrentStudentIdDto currentStudentIdDto) {

		Student student = studentrepo.findById(currentStudentIdDto.getStudentId())
				.orElseThrow(() -> new RuntimeException("Invalid StudentId"));

		StudentDto studentDto = mapper.map(student, StudentDto.class);

//		Course course = courseRepo.findByName(student.getCourse().getName());

		studentDto.setCourseName(student.getCourse().getName());

		Login studentLoginDetails = loginRepo.findById(student.getStudentId())
				.orElseThrow(() -> new RuntimeException("Invalid LoginId"));

		studentDto.setEmail(studentLoginDetails.getEmail());

		return studentDto;

	}

	@Override
	public List<String> getSubjectsList(CurrentStudentIdDto currentStudentIdDto) {

		Student student = studentrepo.findById(currentStudentIdDto.getStudentId())
				.orElseThrow(() -> new RuntimeException("Invalid StudentId"));

		Long courseId = student.getCourse().getCourseId();

		List<String> studentList = subjectCourseRepo.findByCoursesId(courseId)
				.orElseThrow(() -> new RuntimeException("Invalid CourseId"));

		return studentList;
	}

	@Override
	public ModuleDto getModuleList(SubjectCourseDto subjectCourseDto) {

		HashMap<String, String> map = new HashMap<>();

		ModuleDto moduleDto = new ModuleDto();

		Student student = studentrepo.findById(subjectCourseDto.getStudentId())
				.orElseThrow(() -> new RuntimeException("Invalid StudentId"));

		Course course = student.getCourse();

		Subject subject = subjectRepo.findByName(subjectCourseDto.getSubjectName())
				.orElseThrow(() -> new RuntimeException("Invalid Subject Name"));

//		List<String> moduleList=moduleSubjectRepo.findByCourseIdAndSubjectId(course.getCourseId(),subject.getSubjectId())
//				.orElseThrow(()-> new RuntimeException("Invalid Course and Subject ID"));

		Long facultyId = courseSubjectFacultyRepo.findFacultyId(course.getCourseId(), subject.getSubjectId())
				.orElseThrow(() -> new RuntimeException("Invalid Course and Subject ID"));

		Faculty faculty = facultyRepo.findById(facultyId).orElseThrow(() -> new RuntimeException("Invalid Faculty Id"));

//		List<ModuleStatusDto> moduleStatusDto=moduleSubjectRepo.
//				findModuleAndStatusList(course.getCourseId(),subject.getSubjectId())
//					.orElseThrow(()-> new RuntimeException("Invalid Course and Subject ID"));
//		moduleDto.setFacultyName(faculty.getName());
//		moduleDto.setModuleStatusDto(moduleStatusDto);

		List<String> moduleList = moduleSubjectRepo.findByCouseIdAndSubjectId(course.getCourseId(),
				subject.getSubjectId());

		List<String> statusList = moduleSubjectRepo.findStatusByCouseIdAndSubjectId(course.getCourseId(),
				subject.getSubjectId());

		moduleDto.setFacultyName(faculty.getName());

		for (int i = 0; i < moduleList.size(); i++) {
			map.put(moduleList.get(i), statusList.get(i));

		}
		moduleDto.setModuleStatus(map);

		return moduleDto;

	}

	@Override
	public List<StudentMarksArrayObjectDto> getSubjectMarks(CurrentStudentIdDto currentStudentIdDto) {

		SubjectMarksDto subjectMarksDto = new SubjectMarksDto();

		Student student = studentrepo.findById(currentStudentIdDto.getStudentId())
				.orElseThrow(() -> new RuntimeException("Invalid StudentId"));

		Long courseId = student.getCourse().getCourseId();

		List<Integer> marksList = studentMarksRepo.findMarksByStudentIdAndCourseId(student.getStudentId(), courseId);

		List<Long> subjectId = studentMarksRepo.findSubjectIdByStudentIdAndCourseId(student.getStudentId(), courseId);

		List<String> subjectName = new ArrayList<>();

		for (Long subId : subjectId) {

			subjectName.add(subjectRepo.findSubjectNameById(subId)
					.orElseThrow(() -> new RuntimeException("Invalid SubjectId")));

		}
		System.out.println(subjectName.toString());

		for (int i = 0; i < subjectName.size(); i++) {

			subjectMarksDto.getMarkList().add(new StudentMarksArrayObjectDto(marksList.get(i), subjectName.get(i)));

		}

		return subjectMarksDto.getMarkList();
	}

	@Override
	public float getStudentAttendence(CurrentStudentIdDto currentStudentIdDto) {

		AttendencePercentageDto attendencePercentageDto = new AttendencePercentageDto();

		int totalAttendance = studentAttendanceRepo.findTotalAttendanceById(currentStudentIdDto.getStudentId());

		int presentAttendance = studentAttendanceRepo.findpresentAttendanceById(currentStudentIdDto.getStudentId());

		System.out.println(totalAttendance);
		System.out.println(presentAttendance);

		float attendance = ((float) presentAttendance / totalAttendance) * 100;

		System.out.println(attendance);

		attendencePercentageDto.setTotalAttendance(attendance);

		return attendencePercentageDto.getTotalAttendance();
	}

	@Override
	public TimeTableDto getTimeTable(CurrentStudentIdDto currentStudentIdDto) throws IOException {

		TimeTableDto timeTableDto = new TimeTableDto();

		Student student = studentrepo.findById(currentStudentIdDto.getStudentId())
				.orElseThrow(() -> new RuntimeException("Invalid StudentId"));

		Long courseId = student.getCourse().getCourseId();

		DisplayTimetable timetable1 = displayTimetableRepo.findTimeTableByCourseAndDate(courseId);

		if (timetable1 == null) {

			return null;
		}

		timeTableDto.setDate(timetable1.getDate());

		String path = timetable1.getImagePath();
		timeTableDto.setImage(readFileToByteArray(new File(path)));

		return timeTableDto;

	}

}
