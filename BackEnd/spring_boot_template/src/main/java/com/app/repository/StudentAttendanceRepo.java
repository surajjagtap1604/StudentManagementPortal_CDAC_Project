package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.StudentAttendance;

public interface StudentAttendanceRepo extends JpaRepository<StudentAttendance, Long>{

	@Query("select count(*) from StudentAttendance where student_id = :studentId")
	int findTotalAttendanceById(Long studentId);
	@Query("select count(*) from StudentAttendance where student_id = :studentId and attendance = 'P'")
	int findpresentAttendanceById(Long studentId);

}
