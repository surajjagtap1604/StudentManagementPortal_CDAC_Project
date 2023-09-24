package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.app.entity.enums.Attendance;

@Entity

public class StudentAttendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attendanceId;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

	@Enumerated(EnumType.STRING)
	private Attendance attendance;

	private LocalDate date;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Attendance getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Long getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(Long attendanceId) {
		this.attendanceId = attendanceId;
	}

	public StudentAttendance(Long studentId, Long courseId, Long subjectId, Attendance attendance
			) {
		super();
		
		this.student = new Student(studentId);
		this.course = new Course(courseId);
		this.subject = new Subject(subjectId);
		this.attendance = attendance;
		this.date = LocalDate.now();
	}

	public StudentAttendance(Long attendanceId, Student student, Course course, Subject subject, Attendance attendance,
			LocalDate date) {
		super();
		this.attendanceId = attendanceId;
		this.student = student;
		this.course = course;
		this.subject = subject;
		this.attendance = attendance;
		this.date = date;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public StudentAttendance() {
		super();
	}

}