package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Faculty;

public interface FacultyRepo extends JpaRepository<Faculty, Long> {



}
