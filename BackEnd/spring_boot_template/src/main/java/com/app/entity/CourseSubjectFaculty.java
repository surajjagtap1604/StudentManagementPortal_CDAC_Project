package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CourseSubjectFaculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseSubjectFacultyId;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

	@ManyToOne
	@JoinColumn(name = "faculty_id")
	private Faculty faculty;

	public Long getCourseSubjectFacultyId() {
		return courseSubjectFacultyId;
	}

	public void setCourseSubjectFacultyId(Long courseSubjectFacultyId) {
		this.courseSubjectFacultyId = courseSubjectFacultyId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public CourseSubjectFaculty(Long courseSubjectFacultyId, Course course, Subject subject, Faculty faculty) {
		super();
		this.courseSubjectFacultyId = courseSubjectFacultyId;
		this.course = course;
		this.subject = subject;
		this.faculty = faculty;
	}

	public CourseSubjectFaculty() {
		super();
	}

}
