package com.app.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.app.entity.enums.Gender;

@SuppressWarnings("serial")
@Entity
public class Student implements Serializable {


	@Id
	@Column(name = "student_id")
	private Long studentId;

	@OneToOne
	@JoinColumn(name = "student_id") 

	private Login loginId;
    
    @Column(length = 150)
    private String name;

    @Column(length = 15)
    private String phoneNo;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate dob;

    private LocalDate admissionDate;
    private int yearOfPassing;

   

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    
   
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	private List<StudentAttendance> studentAttendance = new ArrayList<>();
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<StudentMarks> studentMarks = new ArrayList<>();
  

    public Student() {
        super();
    }

    public Student(String name, String phoneNo, Gender gender, LocalDate dob, int yearOfPassing, Course course) {
        super();
        this.name = name;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.dob = dob;
        this.yearOfPassing = yearOfPassing;
        this.course = course;
    }

 

    public String getName() {
        return name;
    }

    public Student(Long studentId) {
		super();
		this.studentId = studentId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public Student(Long studentId, String name, String phoneNo, Gender gender, LocalDate dob, LocalDate admissionDate,
			int yearOfPassing,Long courseId) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.dob = dob;
		this.admissionDate = admissionDate;
		this.yearOfPassing = yearOfPassing;
		this.course=new Course(courseId);
	}

	


	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Login getLoginId() {
		return loginId;
	}

	public void setLoginId(Login loginId) {
		this.loginId = loginId;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public List<StudentAttendance> getStudentAttendance() {
		return studentAttendance;
	}

	public void setStudentAttendance(List<StudentAttendance> studentAttendance) {
		this.studentAttendance = studentAttendance;
	}

	public List<StudentMarks> getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(List<StudentMarks> studentMarks) {
		this.studentMarks = studentMarks;
	}

	public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getYearOfPassing() {
        return yearOfPassing;
    }

    public void setYearOfPassing(int yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    

	
    
}