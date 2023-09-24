package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;
	private String name;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<SubjectCourse> subjectCourse = new ArrayList<>();

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Student> studentList = new ArrayList<>();

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<StudentAttendance> studentAttendance = new ArrayList<>();
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<CourseSubjectFaculty> courseSubjectFaculty = new ArrayList<>();
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<StudentMarks> studentMarks = new ArrayList<>();
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<ModuleSubject> moduleSubject = new ArrayList<>();
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<DisplayTimetable> displayTimetable = new ArrayList<>();
	
	
	


	
	

	public Course(Long courseId) {
		super();
		this.courseId = courseId;
	}

	public Course() {
		super();
	}

	public Course(String name) {
		super();
		this.name = name;
	}

	


	public Course(Long courseId, String name) {
		super();
		this.courseId = courseId;
		this.name = name;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public List<SubjectCourse> getSubjectCourse() {
		return subjectCourse;
	}

	public void setSubjectCourse(List<SubjectCourse> subjectCourse) {
		this.subjectCourse = subjectCourse;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<StudentAttendance> getStudentAttendance() {
		return studentAttendance;
	}

	public void setStudentAttendance(List<StudentAttendance> studentAttendance) {
		this.studentAttendance = studentAttendance;
	}

	public List<CourseSubjectFaculty> getCourseSubjectFaculty() {
		return courseSubjectFaculty;
	}

	public void setCourseSubjectFaculty(List<CourseSubjectFaculty> courseSubjectFaculty) {
		this.courseSubjectFaculty = courseSubjectFaculty;
	}

	public List<StudentMarks> getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(List<StudentMarks> studentMarks) {
		this.studentMarks = studentMarks;
	}

	public List<ModuleSubject> getModuleSubject() {
		return moduleSubject;
	}

	public void setModuleSubject(List<ModuleSubject> moduleSubject) {
		this.moduleSubject = moduleSubject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	
}
