package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Transient;

@Entity
public class DisplayTimetable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	

	private LocalDate date;
    
	private String imagePath;


	public DisplayTimetable(Long id, Course course, LocalDate date, String imagePath) {
		super();
		this.id = id;
		this.course = course;
		this.date = date;
		this.imagePath = imagePath;
	}


	public DisplayTimetable(Long courseId, LocalDate date, String imagePath) {
		super();
		this.course = new Course(courseId);
		this.date = date;
		this.imagePath = imagePath;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public DisplayTimetable() {
		super();
	}
	
	 
	
	
	
}
