package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{

	@Query("select name from Student where course_id=:courseId")
	List<String> findStudentNameListByCourseId(Long courseId);

	@Query("select studentId from Student where course_id=:courseId")
	List<Long> findStudentIdListByCourseId(Long courseId);



}
