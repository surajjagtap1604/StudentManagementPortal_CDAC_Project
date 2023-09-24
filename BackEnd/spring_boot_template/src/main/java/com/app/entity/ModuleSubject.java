package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.app.entity.enums.Status;

@Entity
public class ModuleSubject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long moduleId;
	
	private String moduleName;
	
	@ManyToOne
	@JoinColumn(name="subject_id")
	private Subject subject;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}



	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public ModuleSubject(Long moduleId, String moduleName, Subject subject, Course course, Status status) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.subject = subject;
		this.course = course;
		this.status = status;
	}
	
	public ModuleSubject(String moduleName,Long subjectId, Long courseId) {
		

		
		this.moduleName = moduleName;
		this.subject = new Subject(subjectId);
		this.course = new Course(courseId);
		this.status = Status.valueOf("C");
	}
	

	public ModuleSubject() {
		super();
	}
	
	
	
	
	

}
