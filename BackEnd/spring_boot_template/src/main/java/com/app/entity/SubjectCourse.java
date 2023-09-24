package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
//@IdClass(SubjectCourseId.class)
public class SubjectCourse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subjectCourseId;


	@ManyToOne 
    @JoinColumn(name = "subject_id")
    private Subject subject;


    @ManyToOne 
    @JoinColumn(name = "course_id") 
    private Course course;

    private String subjectName;

 

    

	public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

   

    public Long getSubjectCourseId() {
		return subjectCourseId;
	}

	public void setSubjectCourseId(Long subjectCourseId) {
		this.subjectCourseId = subjectCourseId;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public SubjectCourse() {
    }

	public SubjectCourse(Long subjectCourseId, Subject subject, Course course, String subjectName) {
		super();
		this.subjectCourseId = subjectCourseId;
		this.subject = subject;
		this.course = course;
		this.subjectName = subjectName;
	}
	
	
}

