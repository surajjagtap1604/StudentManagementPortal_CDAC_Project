package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subjectId;

	@Column(unique = true)
	private String name;

	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<StudentAttendance> studentAttendance = new ArrayList<>();
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<SubjectCourse> subjectCourse = new ArrayList<>();
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<CourseSubjectFaculty> courseSubjectFaculty = new ArrayList<>();
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<StudentMarks> studentMarks = new ArrayList<>();
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<ModuleSubject> moduleSubject = new ArrayList<>();


	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public Subject(Long subjectId) {
		super();
		this.subjectId = subjectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(Long subjectId, String name) {
		super();
		this.subjectId = subjectId;
		this.name = name;
	}

	

	
	
	

}
