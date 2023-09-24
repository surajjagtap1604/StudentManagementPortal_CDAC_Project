package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StudentMarks {

	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long studentMarksId;
	
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;

	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name="subject_id")
	private Subject subject;
	
	private int marks;

	public Long getStudentMarksId() {
		return studentMarksId;
	}

	public void setStudentMarksId(Long studentMarksId) {
		this.studentMarksId = studentMarksId;
	}

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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public StudentMarks(Long studentMarksId, Student student, Course course, Subject subject, int marks) {
		super();
		this.studentMarksId = studentMarksId;
		this.student = student;
		this.course = course;
		this.subject = subject;
		this.marks = marks;
	}

	public StudentMarks() {
		super();
	}
	
	
	
	
	
}

