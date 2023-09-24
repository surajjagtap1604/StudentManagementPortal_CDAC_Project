package com.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.app.entity.enums.Role;

@Entity
public class Login  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "login_id")
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(length = 20, nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToOne(mappedBy = "loginId", cascade = CascadeType.ALL)
	private Student student;
	
	@OneToOne(mappedBy = "loginId", cascade = CascadeType.ALL)
	private Faculty faculty;
	
	@OneToOne(mappedBy = "loginId", cascade = CascadeType.ALL)
	private Support support;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Login(Long id, String email, String password, Role role, Student student, Faculty faculty) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
		this.student = student;
		this.faculty = faculty;
	}
	
	

	public Login(String email, String password, Role role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

