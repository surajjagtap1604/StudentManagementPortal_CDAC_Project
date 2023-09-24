package com.app.service;

import static org.apache.commons.io.FileUtils.writeByteArrayToFile;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.AddLoginDto;
import com.app.dto.AddStudentDto;
import com.app.dto.AttendanceDto;
import com.app.dto.CourseNameDto;
import com.app.dto.CurrentSupportDto;
import com.app.dto.SupportDto;
import com.app.dto.UpdateAttendanceDto;
import com.app.dto.UploadTimeTableDto;
import com.app.entity.DisplayTimetable;
import com.app.entity.Login;
import com.app.entity.Student;
import com.app.entity.StudentAttendance;
import com.app.entity.Support;
import com.app.entity.enums.Attendance;
import com.app.entity.enums.Gender;
import com.app.entity.enums.Role;
import com.app.repository.CourseRepo;
import com.app.repository.DisplayTimetableRepo;
import com.app.repository.LoginRepo;
import com.app.repository.StudentAttendanceRepo;
import com.app.repository.StudentRepo;
import com.app.repository.SubjectCourseRepo;
import com.app.repository.SubjectRepo;
import com.app.repository.SupportRepo;

@Service
@Transactional
public class SupportServiceImpl implements SupportService {

	@Autowired
	private SupportRepo supportRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private CourseRepo courseRepo;
	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private SubjectCourseRepo subjectCourseRepo;
	@Autowired
	private SubjectRepo subjectRepo;
	@Autowired
	private StudentAttendanceRepo studentAttendanceRepo;
	@Autowired
	private LoginRepo loginRepo;
	@Autowired
	private DisplayTimetableRepo displayTimetableRepo;
	
	
//	private int imageNumber = 1;
	
	
	@Value("${file.upload.location}") // field level DI , <property name n value />
	// ${file.upload.location} SpEL :Spring expr language
	private String uploadFolder;


	@Override
	public SupportDto getSupportDetails(CurrentSupportDto currentSupportDto) {

		Support support = supportRepo.findById(currentSupportDto.getId())
				.orElseThrow(() -> new RuntimeException("Invalid SupportId"));
		SupportDto supportDto = mapper.map(support, SupportDto.class);

		supportDto.setSupportId(support.getLoginId().getId());

		return supportDto;
	}

	@Override
	public List<String> getCoursesList() {

		List<String> coursesList = courseRepo.findAllCourses();
		return coursesList;
	}

	@Override
	public AttendanceDto getStudentAndSubjectList(CourseNameDto courseNameDto) {

		AttendanceDto attendanceDto = new AttendanceDto();
		Long courseId = courseRepo.findCourseIdByCourseName(courseNameDto.getCourseName())
				.orElseThrow(() -> new RuntimeException("Invalid CourseName"));

		HashMap<Long, String> studentIdAndName = new HashMap<>();
		List<String> studentNameList = studentRepo.findStudentNameListByCourseId(courseId);

		List<Long> studentIdList = studentRepo.findStudentIdListByCourseId(courseId);

		for (int i = 0; i < studentIdList.size(); i++) {
			studentIdAndName.put(studentIdList.get(i), studentNameList.get(i));
		}
		attendanceDto.setStudentNameandId(studentIdAndName);

		List<String> subjectNameList = subjectCourseRepo.findByCoursesId(courseId)
				.orElseThrow(() -> new RuntimeException("Invalid Id"));

		attendanceDto.setSubjectsNameList(subjectNameList);
		return attendanceDto;
	}

	@Override
	public String updateAttandance(UpdateAttendanceDto updateAttandanceDto) {

//		try {
//
//			Long courseId = courseRepo.findCourseIdByCourseName(updateAttandanceDto.getCourseName())
//					.orElseThrow(() -> new RuntimeException("Invalid CourseName"));
//
//			LinkedHashSet<Long> keySet = (LinkedHashSet<Long>) updateAttandanceDto.getStudentAttendance().keySet();
//
//			ArrayList<Long> studentIdList = new ArrayList<>(keySet);
//
//			for (int i = 0; i < studentIdList.size(); i++) {
//
//				Long StudentId = studentIdList.get(i);
//
//				HashMap<String, String> valueMap = updateAttandanceDto.getStudentAttendance().get(StudentId);
//
//				LinkedHashSet<String> SetOfSubjectNames = (LinkedHashSet<String>) valueMap.keySet();
//
//				ArrayList<String> SubjectNamesList = new ArrayList<>(SetOfSubjectNames);
//
//				ArrayList<Long> SubjectIdList = new ArrayList<>();
//
//				ArrayList<String> attendanceList = new ArrayList<>();
//
//				for (int j = 0; j < SubjectNamesList.size(); j++) {
//
//					Long subId = subjectRepo.findSubjectIdBySubjectName(SubjectNamesList.get(j))
//							.orElseThrow(() -> new RuntimeException("Invalid subjectName"));
//
//					SubjectIdList.add(subId);
//
//					attendanceList.add(valueMap.get(SubjectNamesList.get(j)));
//
//				}
//
//				StudentAttendance studentAttendance = new StudentAttendance(studentIdList.get(i), courseId,
//						SubjectIdList.get(i), Attendance.valueOf(attendanceList.get(i)));
//
//				studentAttendanceRepo.save(studentAttendance);
//
//			}
//
//			return "Updated Successfully";
//
//		} catch (Exception e) {
//			return "Not Updated Successfully";
//		}

//		

		try {
			// Get the course ID based on the provided course name.
			Long courseId = courseRepo.findCourseIdByCourseName(updateAttandanceDto.getCourseName())
					.orElseThrow(() -> new RuntimeException("Invalid CourseName"));

			// Get the student attendance data and extract student IDs.
			Set<Long> studentIds = updateAttandanceDto.getStudentAttendance().keySet();

			// Loop through each student to update attendance.
			for (Long studentId : studentIds) {
				// Get attendance data (subjects and their attendance values) for the current
				// student.
				Map<String, String> valueMap = updateAttandanceDto.getStudentAttendance().get(studentId);

				// Lists to store subject IDs and attendance values.
				List<Long> subjectIds = new ArrayList<>();
				List<String> attendanceValues = new ArrayList<>();

				// Loop through each subject and its attendance value for the current student.
				for (Map.Entry<String, String> entry : valueMap.entrySet()) {
					String subjectName = entry.getKey();
					String attendanceValue = entry.getValue();

					// Get the subject ID based on the subject name.
					Long subjectId = subjectRepo.findSubjectIdBySubjectName(subjectName)
							.orElseThrow(() -> new RuntimeException("Invalid subjectName"));
					subjectIds.add(subjectId);

					attendanceValues.add(attendanceValue);
				}

				// Loop through each subject and save attendance data for the current student.
				for (int i = 0; i < subjectIds.size(); i++) {
					Long subjectId = subjectIds.get(i);
					String attendanceValue = attendanceValues.get(i);

					// Create a StudentAttendance object and save it to the repository.
					StudentAttendance studentAttendance = new StudentAttendance(studentId, courseId, subjectId,
							Attendance.valueOf(attendanceValue));
					studentAttendanceRepo.save(studentAttendance);
				}
			}

			// If everything goes well, return "Updated Successfully".
			return "Updated Successfully";

		} catch (Exception e) {
			
			return "Not Updated Successfully";
		}

	}

	@Override
	public String createStudent(AddStudentDto addStudentDto) {

		String name = addStudentDto.getName();

		String email = addStudentDto.getEmail();

		LocalDate addmissionDate = addStudentDto.getAdmissionDate();

		LocalDate dob = addStudentDto.getDob();

		String gender = addStudentDto.getGender();

		String phoneNo = addStudentDto.getPhoneNo();

		int yearOfPassing = addStudentDto.getYearOfPassing();

		Long courseId = courseRepo.findCourseIdByCourseName(addStudentDto.getCourseName())
				.orElseThrow(() -> new RuntimeException("Invalid CourseName"));

		Long loginId = loginRepo.findIdByEmail(email).orElseThrow(() -> new RuntimeException("Invalid Email"));

		Student student = new Student(loginId, name, phoneNo, Gender.valueOf(gender), dob, addmissionDate,
				yearOfPassing,courseId);
		
		studentRepo.save(student);
		return "success";
	}

	@Override
	public String createLogin(AddLoginDto addLoginDto) {

		String email = addLoginDto.getEmail();

		String password = addLoginDto.getPassword();

		String role = "Student";

		Login login = new Login(email, password, Role.valueOf(role));

		loginRepo.save(login);
		return "success";

	}

	@Override
	public String uploadTimeTable(String date, MultipartFile image, String course) {
	    try {
	        //String courseName = course;
	        //byte[] image = image.getBytes();
	        //LocalDate date = date;

	        // Here, you should implement the logic to store the uploaded timetable
	    	String path="C:/Users/Acer/Downloads/forProject/spring_boot_template/";
	         path += uploadFolder.concat(image.getOriginalFilename());
	      
	        
	        writeByteArrayToFile(new File(path), image.getBytes());
	        
	        Long courseId = courseRepo.findCourseIdByCourseName(course)
					.orElseThrow(() -> new RuntimeException("Invalid CourseName"));
	        
	        // converting String to LocalDate format
	        LocalDate formattedDate = LocalDate.parse(date);
	        
	        DisplayTimetable displayTimeTimetable = new DisplayTimetable(courseId,formattedDate,path);

	        displayTimetableRepo.save(displayTimeTimetable);

	       

	        return "Timetable uploaded successfully.";
	    } catch (Exception e) {
	        e.printStackTrace(); // Handle the exception properly
	        return "Failed to upload timetable.";
	    }
	}

	


}
